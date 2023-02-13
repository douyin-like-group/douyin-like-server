package com.rocky.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.rocky.MinIOConfig;
import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.VideoBO;
import com.rocky.result.GraceJSONResult;
import com.rocky.service.VideoService;
import com.rocky.utils.MinIOUtils;
import com.rocky.utils.VideoUtil;
import com.rocky.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
// test for file upload
@RequestMapping("/douyin/")
@RestController
@EnableAsync //允许异步
public class VideoController extends BaseInfoProperties {

    @Autowired
    private MinIOConfig minIOConfig;

    @Autowired
    private VideoUtil videoUtil;

    @Autowired
    private VideoService videoService;

    @Autowired
    private MinIOUtils minIOUtils;


    /**
     * 获取某个用户的视频发布列表
     * @param latest_time
     * @param token
     * @return
     * @throws Exception
     */
    @GetMapping("feed")
    public VideoFeedVO getVideoFeed(@RequestParam(required = false) String latest_time,
                                                 @RequestParam(required = false) String token  )throws Exception{

        String userId = redis.get(REDIS_USER_TOKEN+":"+token);
        long sourceUserId;
        if(userId==null){
            sourceUserId = 0L;
        }else{
            sourceUserId = Long.valueOf(userId);
        }


        Date endTime;
        if(latest_time==null||latest_time.length()<=0||latest_time.equals(0)){
             endTime = new Date();
        }else{
             endTime = new Date(Long.valueOf(latest_time));

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
        long sourceUserId = Long.valueOf(value);
        long targetUserId = Long.valueOf(user_id);

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
        //
        log.info("访问");
        String value = redis.get(REDIS_USER_TOKEN+":"+token);


        PublishResultVO publishResultVO = new PublishResultVO();

        if(value==null){
            publishResultVO.setStatusMsg("没有权限访问");
            publishResultVO.setStatusCode(1);
            return publishResultVO;
        }
        long userId = Long.valueOf(value);

        String date= DateUtil.formatDate(new Date());
        String fileName = data.getOriginalFilename();

        // 文件存储的目录结构

        String videoName =DateUtil.currentSeconds()+fileName;



        String imgPath = this.ffmpegGetScreenshot(data);
        log.info(imgPath);
        String imgPathName = DateUtil.currentSeconds()+imgPath.substring(imgPath.lastIndexOf("."));
        BufferedInputStream imgInputStream = FileUtil.getInputStream(imgPath);

        String imgName="img"+"/"+date+"/"+imgPathName;


//
//        存储文件
//        log.info("视频文件上传成功!");
        String videoPath = minIOConfig.getFileHost() + "/" + minIOConfig.getBucketName() + "/" + videoName;
        String imgFinalPath = minIOConfig.getFileHost() + "/" + minIOConfig.getBucketName() + "/" + imgName;

        minIOUtils.uploadFile(minIOConfig.getBucketName(),
                              videoName,
                              data.getInputStream());
        log.info("图片文件上传成功!");

        minIOUtils.uploadFile(minIOConfig.getBucketName(),
                imgName,
                imgInputStream );
        //todo
        // 这里没删除
//        File imgFile = new File(fileName.substring(0,fileName.lastIndexOf("."))+".jpg");
//        File videoFile = new File(fileName);
//        if(imgFile.exists()){
//            log.info("删除图片");
//            imgFile.delete();
//        }
//        if(videoFile.exists()){
//            videoFile.delete();
//        }

        VideoBO videoBO = new VideoBO(userId,title,videoPath,imgFinalPath,(byte)1);
        Boolean success = videoService.createVideo(videoBO);
        videoService.createVideo(videoBO);
        log.info("上传成功");
        publishResultVO.setStatusMsg("发布成功");
        publishResultVO.setStatusCode(0);

        return publishResultVO;

    }
    public String ffmpegGetScreenshot(MultipartFile file) throws IOException {
        File toFile = new File("img/"+file.getOriginalFilename());
        FileUtils.copyInputStreamToFile(file.getInputStream(),toFile);
        //String absolutePath = toFile.getAbsoluteFile().getAbsolutePath();
        Map<String, Object> screenshot = VideoUtil.getScreenshot(toFile);
        String imgPath =(String) screenshot.get("imgPath");
        return imgPath;
    }

}

