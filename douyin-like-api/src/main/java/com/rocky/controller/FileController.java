package com.rocky.controller;


import com.rocky.MinIOConfig;
import com.rocky.result.GraceJSONResult;
import com.rocky.utils.MinIOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
// test for file upload
@RequestMapping("/douyin/publish")
@RestController
public class FileController {

    @Autowired
    private MinIOConfig minIOConfig;

    @PostMapping("/action/")
    public GraceJSONResult upload(MultipartFile file) throws Exception {

        String fileName = file.getOriginalFilename();

        MinIOUtils.uploadFile(minIOConfig.getBucketName(),
                              fileName,
                              file.getInputStream());

        String imgUrl = minIOConfig.getFileHost()
                        + "/"
                        + minIOConfig.getBucketName()
                        + "/"
                        + fileName;

        return GraceJSONResult.ok(imgUrl);
    }
}
