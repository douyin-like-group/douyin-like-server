package com.rocky.service;


import com.rocky.bo.MessageBO;
import com.rocky.pojo.Message;

import java.util.List;
import java.util.Map;




public interface MessageService {
    // todo
    //ChenMolu

    /**
     * 创建消息
     */
    public int createMsg(MessageBO messageBO);

    /**
     * 查询消息列表
     */
    public List<Message> queryList(long fromUserId,long toUserId);
}