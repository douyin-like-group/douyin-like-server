package com.rocky.service;

import com.rocky.bo.RegistLoginBO;
import com.rocky.pojo.Users;
import com.rocky.result.ResultVO;

import com.rocky.vo.UsersVO;
import org.springframework.stereotype.Service;


public interface UsersService {

    //todo


    /**
     * 创建用户并且返回用户信息
     */
    public Users createUser(RegistLoginBO registLoginBO);

    /**
     * 根据请求用户ID和被请求的用户ID查询目标用户信息
     * @param sourceUserId
     * @param targetUserId
     * @return
     */
    public UsersVO findById(long sourceUserId, long targetUserId);

    /**
     * 判断邮件是否存在，返回用户信息
     */
    public Users findByEmail(String email);


    /**
     * 登录
     * @param registLoginBO
     * @return
     */
    public ResultVO login(RegistLoginBO registLoginBO);

    /**
     * 注册
     * @param registLoginBO
     * @return
     */
    public ResultVO register(RegistLoginBO registLoginBO);




 }
