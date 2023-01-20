package com.rocky.service.impl;

import com.rocky.mapper.UsersMapper;
import com.rocky.pojo.Users;
import com.rocky.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Transactional
    @Override
    public Users createUser(String email) {

        return null;
    }

    @Override
    public Users findById(long userId) {
        return null;
    }

    @Override
    public Users findByEmail(String email) {
        return null;
    }
    //todo

}
