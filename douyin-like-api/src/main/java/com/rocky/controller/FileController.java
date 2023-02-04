package com.rocky.controller;


import com.rocky.MinIOConfig;
import com.rocky.result.GraceJSONResult;
import com.rocky.utils.MinIOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
// test for file upload
@RequestMapping("/douyin/publish")
@RestController
public class FileController {

    @Autowired
    private MinIOConfig minIOConfig;

    @PostMapping("/action")
    public GraceJSONResult upload(MultipartFile file) throws Exception {
        //@RequestPart(value="file") MultipartFile file,@RequestPart(value="token") String token,@RequestPart(value="tile") String tile
        log.info("访问");
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
