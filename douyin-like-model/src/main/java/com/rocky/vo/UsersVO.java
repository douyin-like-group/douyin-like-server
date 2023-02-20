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

    protected long id;

    protected String name;

    @JsonProperty("follow_count")
    protected long followCount;

    @JsonProperty("follower_count")
    protected long followerCount;

    @JsonProperty("is_follow")
    protected boolean isFollow;



}
