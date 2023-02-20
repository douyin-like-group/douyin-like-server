package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rocky.pojo.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVO {
    private long id;

    @JsonProperty("to_user_id")
    private long toUserId;

    @JsonProperty("from_user_id")
    private long fromUserId;

    private String content;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    private Date createTime;
    //消息发送时间 yyyy-MM-dd HH:MM:ss



    public MessageVO(Message message){
        this.id = message.getId();
        this.toUserId = message.getVid();
        this.fromUserId = message.getUid();
        this.content = message.getContent();
        this.createTime = message.getCreateTime();

    }

}
//
//    /**
//     * 状态码，0-成功，其他值-失败
//     */
//    @JsonProperty("status_code")
//    private String statusCode;
//    /**
//     * 返回状态描述
//     */
//    @JsonProperty("status_msg")
//    private String statusMsg;
//
//    /**
//     * 用户列表
//     */
//    @JsonProperty("message_list")
//    private List<Message> messageList;
