package com.rocky.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Follow implements Serializable {
    @Id
    private Long id;

    /**
     * 发起关注的用户id
     */
    @Column(name = "from_id")
    private Long fromId;

    /**
     * 被关注的用户id
     */
    @Column(name = "to_id")
    private Long toId;

    /**
     * 0未关注，1关注
     */
    @Column(name = "follow_status")
    private Byte followStatus;

    /**
     * 互关为1，否则为0
     */
    @Column(name = "is_friend")
    private Byte isFriend;

    /**
     * 关注时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
    public Long getFromId() {
        return fromId;
    }

    /**
     * 设置发起关注的用户id
     *
     * @param fromId 发起关注的用户id
     */
    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    /**
     * 获取被关注的用户id
     *
     * @return to_id - 被关注的用户id
     */
    public Long getToId() {
        return toId;
    }

    /**
     * 设置被关注的用户id
     *
     * @param toId 被关注的用户id
     */
    public void setToId(Long toId) {
        this.toId = toId;
    }

    /**
     * 获取0未关注，1关注
     *
     * @return follow_status - 0未关注，1关注
     */
    public Byte getFollowStatus() {
        return followStatus;
    }

    /**
     * 设置0未关注，1关注
     *
     * @param followStatus 0未关注，1关注
     */
    public void setFollowStatus(Byte followStatus) {
        this.followStatus = followStatus;
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
}