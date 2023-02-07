package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Users;

public interface UsersMapper extends MyMapper<Users> {

   public long insertAndGetId(Users user);
}