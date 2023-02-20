package com.rocky.service.impl;


import com.rocky.bo.MessageBO;
import com.rocky.mapper.MessageMapper;
import com.rocky.pojo.Message;
import com.rocky.service.MessageService;
import com.rocky.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    //todo


    @Autowired
    private MessageMapper messageMapper;

    @Override
    @Transactional
    public int createMsg(MessageBO messageBO) {
        Message message = new Message();
        message.setUid(messageBO.getUid());
        message.setVid(messageBO.getVid());
        message.setMessageStatus(messageBO.getMessage_status());
        message.setContent(messageBO.getContent());
        message.setCreateTime(new Date());
        message.setIsFriend((byte) 1);
        int ans = messageMapper.insert(message);
        return ans;
    }


    @Override
    @Transactional
    public List<MessageVO> queryList(long fromUserId, long toUserId, long preMsgTime) {
//        Example msgExample = new Example(Message.class);
//        Example.Criteria criteria = msgExample.createCriteria();
//        criteria.andEqualTo("uid",fromUserId);
//        criteria.andEqualTo("vid",toUserId);
//        criteria.andEqualTo("messageStatus",(byte)0);
//        Date preTime = new Date(preMsgTime);
        List<Message> msgList = messageMapper.findMessageByvidANDuid(fromUserId,toUserId,new Date(preMsgTime));
        List<MessageVO> msgListVO = new ArrayList<>();
        //msgListVO = msgList.stream().map(x -> new MessageVO(x)).collect(Collectors.toList());
        for(Message message:msgList){
            msgListVO.add(new MessageVO(message));
        }
        return msgListVO;
    }




}