package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rocky.pojo.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVO {
//    private long id;
//
//    private String content;
//
//    @JsonProperty("create_time")
//    private String createTime;
//    //消息发送时间 yyyy-MM-dd HH:MM:ss


    /**
     * 状态码，0-成功，其他值-失败
     */
    @JsonProperty("status_code")
    private String statusCode;
    /**
     * 返回状态描述
     */
    @JsonProperty("status_msg")
    private String statusMsg;

    /**
     * 用户列表
     */
    @JsonProperty("message_list")
    private List<Message> messageList;
}
