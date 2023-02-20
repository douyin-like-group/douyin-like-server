package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileReader;
import java.io.Serializable;

//子类的新属性无法反序列化
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendUserVO {

    protected long id;

    protected String name;

    @JsonProperty("follow_count")
    protected long followCount;

    @JsonProperty("follower_count")
    protected long followerCount;

    @JsonProperty("is_follow")
    protected boolean isFollow;

    private long msgType;
    // message消息的类型，0 => 当前请求用户接收的消息， 1 => 当前请求用户发送的消息

    private String message;

    public FriendUserVO(UsersVO usersVO,String content,long msgType){

        this.id =  usersVO.getId();
        this.name =  usersVO.getName();
        this.followCount =  usersVO.getFollowCount();
        this.followerCount =  usersVO.getFollowerCount();
        this.isFollow =  usersVO.isFollow();
        this.message = content;
        this.msgType = msgType;


    }



}
