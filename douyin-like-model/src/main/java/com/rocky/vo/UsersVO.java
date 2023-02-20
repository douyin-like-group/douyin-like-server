package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.checkerframework.checker.units.qual.A;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS,property = "classname")
public class UsersVO implements Serializable {

    private long id;

    private String name;

    @JsonProperty("follow_count")
    private long followCount;

    @JsonProperty("follower_count")
    private long followerCount;

    @JsonProperty("is_follow")
    private boolean isFollow;

    private  final String signature = "欢迎访问我的个人主页！";

    @JsonProperty("background_image")
    private final String backgroundImage = "https://s3-ap-northeast-1.amazonaws.com/thegate/2021/01/05/13/09/02/Heianjingu-shrine.jpg";

    private final String avatar = "https://cdn-icons-png.flaticon.com/512/3884/3884851.png";



}
