package com.rocky.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private Integer status_code;

    // 响应消息
    private String status_msg;

    // 响应数据，可以是Object，也可以是List或Map等
    private Object data;
}
