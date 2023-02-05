package com.rocky.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Favorite implements Serializable {
    @Id
    private Long id;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 喜欢的短视频id
     */
    private Long vid;

    /**
     * 0未点赞，1已点赞
     */
    @Column(name = "favorite_status")
    private Byte favoriteStatus;

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
     * 获取用户id
     *
     * @return uid - 用户id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置用户id
     *
     * @param uid 用户id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取喜欢的短视频id
     *
     * @return vid - 喜欢的短视频id
     */
    public Long getVid() {
        return vid;
    }

    /**
     * 设置喜欢的短视频id
     *
     * @param vid 喜欢的短视频id
     */
    public void setVid(Long vid) {
        this.vid = vid;
    }

    /**
     * 获取0未点赞，1已点赞
     *
     * @return favorite_status - 0未点赞，1已点赞
     */
    public Byte getFavoriteStatus() {
        return favoriteStatus;
    }

    /**
     * 设置0未点赞，1已点赞
     *
     * @param favoriteStatus 0未点赞，1已点赞
     */
    public void setFavoriteStatus(Byte favoriteStatus) {
        this.favoriteStatus = favoriteStatus;
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