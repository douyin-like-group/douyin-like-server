package com.rocky.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterLoginVO {

    private Integer status_code;

    private String status_msg;

    @JsonProperty("user_id")
    private long userId;

    private String token;


}
