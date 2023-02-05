package com.rocky.service;

import com.rocky.pojo.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {
    // todo
    //ChenMolu

    /**
     * 创建消息
     */
    public void createMsg(String fromUserId,String toUserId);

    /**
     * 查询消息列表
     */
    public List<Message> queryList(String toUserId,Integer page,Integer pageSize);
}
