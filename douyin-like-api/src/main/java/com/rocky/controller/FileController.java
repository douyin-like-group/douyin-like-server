package com.rocky.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.rocky.MinIOConfig;
import com.rocky.result.GraceJSONResult;
import com.rocky.utils.MinIOUtils;
import com.rocky.utils.VideoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Slf4j
// test for file upload
@RequestMapping("/douyin/publish")
@RestController
public class FileController {

    @Autowired
    private MinIOConfig minIOConfig;

    @Autowired
    private VideoUtil videoUtil;

    @PostMapping("/action")
    public GraceJSONResult upload(
            @RequestPart(value="data") MultipartFile data,
            @RequestPart(value="token") String token,
            @RequestPart(value="title") String title

                                   ) throws Exception {
        //
        log.info("访问");

        String date= DateUtil.formatDate(new Date());
        String fileName = data.getOriginalFilename();
        String videoType = data.getContentType();
        // 文件存储的目录结构

        String videoName =videoType+"/"+date+"/"+fileName;

        String imgPath = this.ffmpegGetScreenshot(data);
        String imgPathName = DateUtil.currentSeconds()+imgPath.substring(imgPath.lastIndexOf("."));
        BufferedInputStream imgInputStream = FileUtil.getInputStream(imgPath);

        String imgName="img"+"/"+date+"/"+imgPathName;


        log.info("图片文件上传成功!");
        // 存储文件
        log.info("视频文件上传成功!");
        String videoPath = minIOConfig.getFileHost() + "/" + minIOConfig.getBucketName() + "/" + videoName;
        String imgFinalPath = minIOConfig.getFileHost() + "/" + minIOConfig.getBucketName() + "/" + imgName;



        MinIOUtils.uploadFile(minIOConfig.getBucketName(),
                              videoName,
                              data.getInputStream());
        MinIOUtils.uploadFile(minIOConfig.getBucketName(),
                imgFinalPath,
                imgInputStream );



        return GraceJSONResult.ok(videoPath+":"+imgFinalPath);
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

