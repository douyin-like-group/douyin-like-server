package com.rocky.service.impl;

import com.rocky.bo.RegistLoginBO;
import com.rocky.mapper.UsersMapper;
import com.rocky.pojo.Users;
import com.rocky.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;



@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    @Override
    public Users createUser(RegistLoginBO registLoginBO) {

        Users  user = new Users();
        //todo 上传用户名与否
        user.setUsername("tempUsername");
        user.setPassword(passwordEncoder.encode(registLoginBO.getPassword()));
        user.setEmail(registLoginBO.getUsername());
        // 这里username 就是email
        user.setPhone("000-0000-0000");
        user.setFollowCount(0L);
        user.setFollowerCount(0L);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }

    @Override
    public Users findById(long userId) {
        return null;
    }

    @Override
    public Users findByEmail(String email) {
        Example userExample= new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("email",email);
        Users user = usersMapper.selectOneByExample(userExample);
        return user;
    }
    //todo

}
