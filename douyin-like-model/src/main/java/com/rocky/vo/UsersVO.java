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
@ToString
public class UsersVO {
    private Integer status_code;
    private String status_msg;
    private long id;
    private String name;
    private long follow_count;
    private long follower_count;
    private boolean is_follow;

}
