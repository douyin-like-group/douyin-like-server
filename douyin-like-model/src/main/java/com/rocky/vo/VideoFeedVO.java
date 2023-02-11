package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoFeedVO {

        @JsonProperty("status_code")
        private Integer statusCode;

        @JsonProperty("status_msg")
        private String statusMsg;
        // 响应消息
        @JsonProperty("next_time")
        private long nextTime;

        // 响应数据，可以是Object，也可以是List或Map等
        @JsonProperty("video_list")
        private Object videoList;


}
