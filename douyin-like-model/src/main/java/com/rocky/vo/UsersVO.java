package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.checkerframework.checker.units.qual.A;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersVO {

    private long id;

    private String name;

    @JsonProperty("follow_count")
    private long followCount;

    @JsonProperty("follower_count")
    private long followerCount;

    @JsonProperty("is_follow")
    private boolean isFollow;

}
