package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rocky.pojo.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {

    private long id;

    private UsersVO user;

    private String content;

    @JsonProperty("create_date")
    private String createDate;
    //评论发布日期，格式 mm-dd


}
