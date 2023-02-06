package com.rocky.service.impl;


import com.rocky.pojo.Message;
import com.rocky.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl {

    //todo

    @Override
    public void createMsg(String fromUserId, String toUserId) {

    }

    @Override
    public List<Message> queryList(String toUserId, Integer page, Integer pageSize) {
        return null;
    }

}
