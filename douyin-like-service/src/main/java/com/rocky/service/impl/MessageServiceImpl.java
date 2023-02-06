package com.rocky.service.impl;


import com.rocky.pojo.Message;
import com.rocky.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {

    //todo

    @Override
    public void createMsg(String fromUserId, String toUserId) {

    }

    @Override
    public List<Message> queryList(String toUserId, Integer page, Integer pageSize) {
        return null;
    }

}
