package com.rocky.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterLoginVO {

    @JsonProperty("status_code")
    private Integer statusCode;

    @JsonProperty("status_msg")
    private String statusMsg;

    @JsonProperty("user_id")
    private long userId;

    private String token;


}
