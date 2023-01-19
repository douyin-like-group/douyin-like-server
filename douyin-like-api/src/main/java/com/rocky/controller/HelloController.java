package com.rocky.controller;

import com.rocky.result.GraceJSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public Object hello() {
        return GraceJSONResult.ok( "Hello SpringBoot~");
    }

}
