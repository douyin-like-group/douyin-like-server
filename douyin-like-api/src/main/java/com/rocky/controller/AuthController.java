package com.rocky.controller;

import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.RegistLoginBO;
import com.rocky.mapper.UsersMapper;
import com.rocky.pojo.Users;
import com.rocky.result.GraceJSONResult;
import com.rocky.service.UsersService;
import com.rocky.vo.UsersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;


@RestController
@RequestMapping("/douyin/user")
public class AuthController extends BaseInfoProperties {




    @Autowired
    private UsersService usersService;



    @PostMapping("/register")
    public GraceJSONResult register(@Valid @RequestBody RegistLoginBO registLoginBO,
                                    BindingResult result,
                                    HttpServletRequest request) throws Exception{
        String email  = registLoginBO.getUsername();
        String password = registLoginBO.getPassword();

        Users user = usersService.findByEmail(registLoginBO.getUsername());
        if(user != null){
            return GraceJSONResult.errorMsg("邮件地址已存在");

        }
        user = usersService.createUser(registLoginBO);

        String uToken = UUID.randomUUID().toString();
        redis.set(REDIS_USER_TOKEN+":"+user.getId(), uToken);
        UsersVO usersVO = new UsersVO();
        BeanUtils.copyProperties(user,usersVO);
        usersVO.setToken(uToken);
        usersVO.setUser_id(user.getId());
        return GraceJSONResult.ok(usersVO);
    }





}
