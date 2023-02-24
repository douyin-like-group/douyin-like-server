package com.rocky.controller;

import com.rocky.result.ResponseStatusEnum;
import com.rocky.utils.BaseInfoProperties;
import com.rocky.bo.RegistLoginBO;
import com.rocky.service.UsersService;

import com.rocky.utils.UserAuth;

import com.rocky.result.ResultVO;
import com.rocky.vo.UsersVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/douyin/user")
@Validated
@Slf4j
public class UserController extends BaseInfoProperties {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    @ResponseBody
    public ResultVO register(@RequestParam(name="username") @Email(message="请输入正确的邮箱地址")String email, String password) {
        log.info("/douyin/user/register 接口捕获");


        return usersService.register(new RegistLoginBO(email,password));

    }

    @PostMapping("/login")
    public ResultVO login(@RequestParam(name="username") String email, String password) {
        log.info("/douyin/user/login 接口捕获");


        return usersService.login(new RegistLoginBO(email,password));

    }
    @GetMapping("")
    @UserAuth // user authentication
    public ResultVO query(@RequestParam(name="user_id") @NotEmpty(message="user_id不能为空") String targetUserIdStr,
                                          String token) throws Exception{

        log.info("/douyin/user 接口捕获");


        String userId = redis.get(REDIS_USER_TOKEN+":"+token);
        long sourceUserId = Long.valueOf(userId);
        long targetUserId = Long.valueOf(targetUserIdStr);
        UsersVO usersVO = usersService.findById(sourceUserId,targetUserId);
        //find user info by sourceId and targetId
        return  ResultVO.ok(ResponseStatusEnum.SUCCESS,"user",usersVO);
    }



}
