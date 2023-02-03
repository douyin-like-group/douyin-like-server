package com.rocky.controller;

import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.RegistLoginBO;
import com.rocky.pojo.Users;
import com.rocky.result.GraceJSONResult;
import com.rocky.service.UsersService;
import com.rocky.vo.RegisterLoginVO;
import com.rocky.vo.ResultVO;
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
        if(registerLoginVO.getStatusCode().equals(1)){
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
        if(registerLoginVO.getStatusCode().equals(1)){
            return new ResponseEntity<>(registerLoginVO,HttpStatus.BAD_REQUEST);
        }
         return ResponseEntity.ok(registerLoginVO);
    }
    @GetMapping("/")
    public ResponseEntity<ResultVO> query(@RequestParam String user_id,String token){

        String value = redis.get(REDIS_USER_TOKEN+":"+token);
        UsersVO usersVO = new UsersVO();
        ResultVO resultVO = new ResultVO();

        if(value==null){
            resultVO.setStatusMsg("没有权限访问");
            resultVO.setStatusCode(1);

            return new ResponseEntity<>(resultVO, HttpStatus.BAD_REQUEST);
        }
        long sourceUserId = Long.valueOf(value);
        long targetUserId = Long.valueOf(user_id);
        resultVO.setStatusCode(0);
        resultVO.setStatusMsg("成功访问用户页面");
        usersVO.setId(targetUserId);
        Users user = usersService.findById(targetUserId);
        usersVO.setName(user.getUsername());
        usersVO.setFollowCount(user.getFollowCount());
        usersVO.setFollowerCount(user.getFollowerCount());
        //todo find by sourceId and targetId
        Boolean isFollow = true;
        usersVO.setFollow(isFollow);
        resultVO.setData(usersVO);

        return  ResponseEntity.ok(resultVO);
    }

}
