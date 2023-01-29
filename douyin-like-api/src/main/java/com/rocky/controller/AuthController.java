package com.rocky.controller;

import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.RegistLoginBO;
import com.rocky.pojo.Users;
import com.rocky.result.GraceJSONResult;
import com.rocky.service.UsersService;
import com.rocky.vo.RegisterLoginVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;



@Api(tags={"auth注册登录接口"})
@Slf4j
@RestController
@RequestMapping("/douyin/user")
public class AuthController extends BaseInfoProperties {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    @ResponseBody
    public RegisterLoginVO register(@RequestParam String username, String password) {
        RegistLoginBO registLoginBO = new RegistLoginBO();
        registLoginBO.setPassword(password);
        registLoginBO.setUsername(username);
        RegisterLoginVO registerLoginVO = usersService.register(registLoginBO);
        return registerLoginVO;
    }

    @PostMapping("/login")
    public RegisterLoginVO login(@RequestParam String username, String password) {
        RegistLoginBO registLoginBO = new RegistLoginBO();
        registLoginBO.setPassword(password);
        registLoginBO.setUsername(username);
        RegisterLoginVO registerLoginVO = usersService.login(registLoginBO);
         return registerLoginVO;
    }
    @GetMapping("/")
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
