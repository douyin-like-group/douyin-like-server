package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MessageMapper extends MyMapper<Message> {
    List<Message> findMessageByvidANDuid(@Param("uid") long from_user_id,
                                         @Param("vid") long to_user_id,
                                         @Param("pre_msg_time" ) Date preMsgTime);
}