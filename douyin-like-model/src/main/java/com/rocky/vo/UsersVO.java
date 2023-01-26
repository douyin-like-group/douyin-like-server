package com.rocky.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersVO {

    private long user_id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private long followCount;
    private long followerCount;
    private Date createdTime;
    private Date updatedTime;
    private String token;
}
