package com.rocky.controller;

import com.rocky.result.UserR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 仅作为测试使用
 */

@RestController
@Slf4j
@RequestMapping("/douyin/user")
public class TestController {

    @PostMapping ("/login")
    public UserR login(@RequestParam String username, String password){
        log.info("访问login接口"+username);
        UserR userR = new UserR();
        userR.setStatusCode(0);
        userR.setUserid(159L);
        userR.setStatusMsg(username+" "+password);
        userR.setToken("1555445");
        return userR;
    }

    @GetMapping
    public String query(String user_id,String token){
        String str = "{\n" +
                "    \"status_code\": 0,\n" +
                "    \"status_msg\": \"string\",\n" +
                "    \"user\": {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"string\",\n" +
                "        \"follow_count\": 0,\n" +
                "        \"follower_count\": 0,\n" +
                "        \"is_follow\": true\n" +
                "    }\n" +
                "}";
        return  str;
    }
}
