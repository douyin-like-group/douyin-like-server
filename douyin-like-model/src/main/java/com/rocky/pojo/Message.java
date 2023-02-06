package com.rocky.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Message implements Serializable {
    @Id
    private Long id;

    /**
     * 发送者 id
     */
    private Long uid;

    /**
     * 接受者 id
     */
    private Long vid;

    /**
     * 互关为1，否则为0
     */
    @Column(name = "is_friend")
    private Byte isFriend;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 关注时间
     */
    @Column(name = "create_time")
    @JsonProperty("create_time")
    private Date createTime;

    /**
     * 0-未读，1-已读，2-删除
     */
    @Column(name = "message_status")
    private Byte messageStatus;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取发送者 id
     *
     * @return uid - 发送者 id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置发送者 id
     *
     * @param uid 发送者 id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取接受者 id
     *
     * @return vid - 接受者 id
     */
    public Long getVid() {
        return vid;
    }

    /**
     * 设置接受者 id
     *
     * @param vid 接受者 id
     */
    public void setVid(Long vid) {
        this.vid = vid;
    }

    /**
     * 获取互关为1，否则为0
     *
     * @return is_friend - 互关为1，否则为0
     */
    public Byte getIsFriend() {
        return isFriend;
    }

    /**
     * 设置互关为1，否则为0
     *
     * @param isFriend 互关为1，否则为0
     */
    public void setIsFriend(Byte isFriend) {
        this.isFriend = isFriend;
    }

    /**
     * 获取留言内容
     *
     * @return content - 留言内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置留言内容
     *
     * @param content 留言内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取关注时间
     *
     * @return create_time - 关注时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置关注时间
     *
     * @param createTime 关注时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取0-未读，1-已读，2-删除
     *
     * @return message_status - 0-未读，1-已读，2-删除
     */
    public Byte getMessageStatus() {
        return messageStatus;
    }

    /**
     * 设置0-未读，1-已读，2-删除
     *
     * @param messageStatus 0-未读，1-已读，2-删除
     */
    public void setMessageStatus(Byte messageStatus) {
        this.messageStatus = messageStatus;
    }
}