package com.rocky.controller;

import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.RegistLoginBO;
import com.rocky.service.UsersService;
import com.rocky.vo.RegisterLoginVO;
import com.rocky.vo.ResultVO;
import com.rocky.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/douyin/user")
public class UserController extends BaseInfoProperties {

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
        UsersVO usersVO = usersService.findById(sourceUserId,targetUserId);

        //todo find by sourceId and targetId

        resultVO.setData(usersVO);
        resultVO.setObjectName("user");

        return  ResponseEntity.ok(resultVO);
    }



}
