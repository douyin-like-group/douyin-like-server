package com.rocky.service;

import com.rocky.bo.RegistLoginBO;
import com.rocky.pojo.Users;

public interface UsersService {

    //todo

    /**
     * 创建用户并且返回用户信息
     */
    public Users createUser(RegistLoginBO registLoginBO);

    /**
     * 根据用户主键查询用户
     * @param userId
     * @return
     */
    public Users findById(long userId);

    /**
     * 判断邮件是否存在，返回用户信息
     */
    public Users findByEmail(String email);




 }
