package com.example.thrd.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Follow implements Serializable {
    @Id
    private Long id;

    /**
     * 发起关注的用户id
     */
    private Long from_id;

    /**
     * 被关注的用户id
     */
    private Long to_id;

    /**
     * 互关为1，否则为0
     */
    private Byte is_friend;

    /**
     * 关注时间
     */
    private Date create_time;

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
     * 获取发起关注的用户id
     *
     * @return from_id - 发起关注的用户id
     */
    public Long getFrom_id() {
        return from_id;
    }

    /**
     * 设置发起关注的用户id
     *
     * @param from_id 发起关注的用户id
     */
    public void setFrom_id(Long from_id) {
        this.from_id = from_id;
    }

    /**
     * 获取被关注的用户id
     *
     * @return to_id - 被关注的用户id
     */
    public Long getTo_id() {
        return to_id;
    }

    /**
     * 设置被关注的用户id
     *
     * @param to_id 被关注的用户id
     */
    public void setTo_id(Long to_id) {
        this.to_id = to_id;
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
}