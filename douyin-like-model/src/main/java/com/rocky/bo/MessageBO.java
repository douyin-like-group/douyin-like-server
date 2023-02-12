package com.rocky.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBO {

    //发送方Id
    private long uid;

    //接收方Id
    private long vid;

    //消息内容
    private String content;

    //发送的消息状态
    private Byte message_status;
}