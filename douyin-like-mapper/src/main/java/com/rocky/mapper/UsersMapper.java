package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Users;

public interface UsersMapper extends MyMapper<Users> {

   long insertAndGetId(Users user);
}