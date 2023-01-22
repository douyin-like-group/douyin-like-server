package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageMapper extends MyMapper<Message> {
}