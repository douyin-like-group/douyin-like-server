package com.example.thrd.pojo;

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
    private Byte is_friend;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 关注时间
     */
    private Date create_time;

    /**
     * 0-未读，1-已读，2-删除
     */
    private Byte message_status;

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
    public Byte getIs_friend() {
        return is_friend;
    }

    /**
     * 设置互关为1，否则为0
     *
     * @param is_friend 互关为1，否则为0
     */
    public void setIs_friend(Byte is_friend) {
        this.is_friend = is_friend;
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
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * 设置关注时间
     *
     * @param create_time 关注时间
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * 获取0-未读，1-已读，2-删除
     *
     * @return message_status - 0-未读，1-已读，2-删除
     */
    public Byte getMessage_status() {
        return message_status;
    }

    /**
     * 设置0-未读，1-已读，2-删除
     *
     * @param message_status 0-未读，1-已读，2-删除
     */
    public void setMessage_status(Byte message_status) {
        this.message_status = message_status;
    }
}