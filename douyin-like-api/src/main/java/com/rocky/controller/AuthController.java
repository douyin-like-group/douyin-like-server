package com.rocky.controller;

import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.RegistLoginBO;
import com.rocky.pojo.Users;
import com.rocky.result.GraceJSONResult;
import com.rocky.service.UsersService;
import com.rocky.vo.RegisterLoginVO;
import com.rocky.vo.UsersVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;




@RestController
@RequestMapping("/douyin/user")
public class AuthController extends BaseInfoProperties {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<RegisterLoginVO> register(@RequestParam String username, String password) {
        RegistLoginBO registLoginBO = new RegistLoginBO();
        registLoginBO.setPassword(password);
        registLoginBO.setUsername(username);
        RegisterLoginVO registerLoginVO = usersService.register(registLoginBO);
        if(registerLoginVO.getStatus_code().equals(1)){
            return new ResponseEntity<>(registerLoginVO,HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(registerLoginVO);
    }

    @PostMapping("/login")
    public ResponseEntity<RegisterLoginVO> login(@RequestParam String username, String password) {
        RegistLoginBO registLoginBO = new RegistLoginBO();
        registLoginBO.setPassword(password);
        registLoginBO.setUsername(username);
        RegisterLoginVO registerLoginVO = usersService.login(registLoginBO);
        if(registerLoginVO.getStatus_code().equals(1)){
            return new ResponseEntity<>(registerLoginVO,HttpStatus.BAD_REQUEST);
        }
         return ResponseEntity.ok(registerLoginVO);
    }
    @GetMapping("/")
    public ResponseEntity<UsersVO> query(@RequestParam String user_id,String token){

        String value = redis.get(REDIS_USER_TOKEN+":"+token);
        UsersVO usersVO = new UsersVO();
        usersVO.setStatus_msg("没有权限访问");
        if(value==null){
            return new ResponseEntity<>(usersVO, HttpStatus.BAD_REQUEST);
        }
        long sourceUserId = Long.valueOf(value);
        long targetUserId = Long.valueOf(user_id);
        usersVO.setStatus_code(0);
        usersVO.setStatus_msg("成功访问用户页面");
        usersVO.setId(targetUserId);
        Users user = usersService.findById(targetUserId);
        usersVO.setName(user.getUsername());
        usersVO.setFollow_count(user.getFollowCount());
        usersVO.setFollower_count(user.getFollowerCount());
        //todo find by sourceId and targetId
        Boolean isFollow = true;
        usersVO.set_follow(isFollow);

        return  ResponseEntity.ok(usersVO);
    }

}
