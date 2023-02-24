package com.rocky.controller;


import cn.hutool.core.date.DateUtil;

import com.rocky.MinIOConfig;
import com.rocky.result.ResponseStatusEnum;
import com.rocky.utils.BaseInfoProperties;
import com.rocky.bo.VideoBO;

import com.rocky.result.ResultVO;
import com.rocky.service.VideoService;
import com.rocky.utils.MinIOUtils;

import com.rocky.utils.UserAuth;
import com.rocky.vo.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import java.util.UUID;

@Slf4j
@RequestMapping("/douyin/")
@RestController
@EnableAsync //允许异步
@Validated
public class VideoController extends BaseInfoProperties {

    @Autowired
    private MinIOConfig minIOConfig;


    @Autowired
    private VideoService videoService;

    @Autowired
    private MinIOUtils minIOUtils;


    /**
     * 获取某个用户的视频发布列表
     * @param latestTime
     * @param token
     * @return
     * @throws Exception
     */



    @GetMapping("feed")
    public ResultVO getVideoFeed(@RequestParam(required = false,value="latest_time") String latestTime,
                                                 @RequestParam(required = false,value="token") String token  )throws Exception{
        log.info("/douyin/feed 接口捕获");


        String userId = redis.get(REDIS_USER_TOKEN+":"+token);
        long sourceUserId;
        if(userId==null){
            sourceUserId = 0L;
        }else{
            sourceUserId = Long.parseLong(userId);
        }

        Date endTime;
        if(latestTime==null||latestTime.equals("")){
             endTime = new Date();
        }else{
             endTime = new Date(Long.parseLong(latestTime));

        }


//        log.info(String.valueOf(endTime));
        List<VideoVO> videoVOList = videoService.findVideoFeed(sourceUserId,endTime);
        long nextTime;
        if(videoVOList==null|| videoVOList.isEmpty()||videoVOList.size()==0){
            nextTime = new Date().getTime();
        }else{
            nextTime =videoService.findDateById(videoVOList.get(0).getId()).getTime();
        }
        nextTime /= 1000;

        ResultVO resultVO = new ResultVO(ResponseStatusEnum.SUCCESS,"video_list",videoVOList);

        resultVO.setNextTime(nextTime);

        return resultVO;

    }

    @GetMapping("publish/list")
    @UserAuth
    public ResultVO getVideoList(
            @RequestParam(value="token") String token,
            @RequestParam(value="user_id") String user_id
    )throws Exception{
        log.info("/douyin/publish/list 接口捕获");


        String value = redis.get(REDIS_USER_TOKEN+":"+token);


        long sourceUserId = Long.parseLong(value);
        long targetUserId = Long.parseLong(user_id);

        List<VideoVO> videoVOList = videoService.getAllVideoList(sourceUserId,targetUserId);

        return ResultVO.ok(ResponseStatusEnum.SUCCESS,"video_list",videoVOList);

    }
    @PostMapping("publish/action")
    @UserAuth
    public ResultVO upload(
            @NotNull(message="视频不能为空")  @RequestPart(value="data") MultipartFile data,
            @RequestPart(value="token") String token,
            @RequestPart(value="title") @NotBlank(message="标题不能为空") String title

                                   ) throws Exception {

        log.info("/douyin/publish/action 接口捕获");

        String value = redis.get(REDIS_USER_TOKEN+":"+token);

        String contenType = data.getOriginalFilename().substring(data.getOriginalFilename().lastIndexOf("."));
        if(!contenType.equals(".mp4")){
            return ResultVO.error(ResponseStatusEnum.UPLOAD_ERR);
        }
        long userId = Long.parseLong(value);

        String date= DateUtil.formatDate(new Date());
        // 文件存储的目录结构

        //String videoName =DateUtil.currentSeconds()+fileName;

        String videoName = "video/"+date+ "/"+UUID.randomUUID()+contenType;
        String coverName = "cover/"+date+ "/"+UUID.randomUUID()+".png";
        minIOUtils.uploadVideoAndCutCover(minIOConfig.getBucketName(),
                videoName,coverName,
                data.getInputStream());
        String videoPath = minIOConfig.getFileHost() + "/" + minIOConfig.getBucketName() + "/" + videoName;
        String coverPath = minIOConfig.getFileHost() + "/" + minIOConfig.getBucketName() + "/" + coverName;



        // 插入地址
        VideoBO videoBO = new VideoBO(userId,title,videoPath,coverPath,(byte)1);

        videoService.createVideo(videoBO);
//        log.info("插入数据库成功");


        return ResultVO.ok(ResponseStatusEnum.SUCCESS);

    }


}

