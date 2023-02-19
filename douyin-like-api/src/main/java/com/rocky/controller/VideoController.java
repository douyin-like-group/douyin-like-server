package com.rocky.controller;


import cn.hutool.core.date.DateUtil;

import com.rocky.MinIOConfig;
import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.VideoBO;

import com.rocky.service.VideoService;
import com.rocky.utils.MinIOUtils;

import com.rocky.vo.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.List;

import java.util.UUID;

@Slf4j
// test for file upload
@RequestMapping("/douyin/")
@RestController
@EnableAsync //允许异步
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
    public VideoFeedVO getVideoFeed(@RequestParam(required = false,value="latest_time") String latestTime,
                                                 @RequestParam(required = false,value="token") String token  )throws Exception{

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

        VideoFeedVO videoFeedVO = new VideoFeedVO();
        videoFeedVO.setStatusMsg("访问成功");
        videoFeedVO.setStatusCode(0);
        videoFeedVO.setVideoList(videoVOList);
        videoFeedVO.setNextTime(nextTime);
        return videoFeedVO;

    }

    @GetMapping("publish/list")
    public ResultVO getVideoList(
            @RequestParam(value="token") String token,
            @RequestParam(value="user_id") String user_id
    )throws Exception{
        String value = redis.get(REDIS_USER_TOKEN+":"+token);

        ResultVO resultVO = new ResultVO();

        if(value==null){
            resultVO.setStatusMsg("没有权限访问");
            resultVO.setStatusCode(1);
            return resultVO;
        }
        long sourceUserId = Long.parseLong(value);
        long targetUserId = Long.parseLong(user_id);

        List<VideoVO> videoVOList = videoService.getAllVideoList(sourceUserId,targetUserId);
        resultVO.setStatusMsg("访问成功");
        resultVO.setStatusCode(0);
        resultVO.setData(videoVOList);
        resultVO.setObjectName("video_list");
        return resultVO;

    }
    @PostMapping("publish/action")
    public PublishResultVO upload(
            @RequestPart(value="data") MultipartFile data,
            @RequestPart(value="token") String token,
            @RequestPart(value="title") String title

                                   ) throws Exception {

        log.info("访问发布视频接口");
        String value = redis.get(REDIS_USER_TOKEN+":"+token);


        PublishResultVO publishResultVO = new PublishResultVO();


        if(value==null){
            publishResultVO.setStatusMsg("没有权限访问");
            publishResultVO.setStatusCode(1);
            return publishResultVO;
        }
        String contenType = data.getOriginalFilename().substring(data.getOriginalFilename().lastIndexOf("."));
        if(!contenType.equals(".mp4")){
            publishResultVO.setStatusMsg("请上传mp4类型的视频");
            publishResultVO.setStatusCode(1);
            return publishResultVO;
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
        publishResultVO.setStatusMsg("发布成功");
        publishResultVO.setStatusCode(0);

        return publishResultVO;

    }


}

