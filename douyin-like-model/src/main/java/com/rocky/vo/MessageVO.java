package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVO {
    private long id;

    private String content;

    @JsonProperty("create_time")
    private String createTime;
    //消息发送时间 yyyy-MM-dd HH:MM:ss


}
