package com.rocky.pojo;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
    @Id
    private Long id;

    /**
     * 对应用户表id，视频发布者
     */
    private Long uid;

    /**
     * 视频播放地址
     */
    private String play_url;

    /**
     * 视频封面地址
     */
    private String cover_url;

    /**
     * 视频标题，可以为空
     */
    private String title;

    /**
     * 评论总数
     */
    private Long comments_count;

    /**
     * 点赞总数
     */
    private Long favorite_count;

    /**
     * 创建时间
     */
    private Date created_time;

    /**
     * 更新时间
     */
    private Date updated_time;

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
     * 获取对应用户表id，视频发布者
     *
     * @return uid - 对应用户表id，视频发布者
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置对应用户表id，视频发布者
     *
     * @param uid 对应用户表id，视频发布者
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取视频播放地址
     *
     * @return play_url - 视频播放地址
     */
    public String getPlay_url() {
        return play_url;
    }

    /**
     * 设置视频播放地址
     *
     * @param play_url 视频播放地址
     */
    public void setPlay_url(String play_url) {
        this.play_url = play_url;
    }

    /**
     * 获取视频封面地址
     *
     * @return cover_url - 视频封面地址
     */
    public String getCover_url() {
        return cover_url;
    }

    /**
     * 设置视频封面地址
     *
     * @param cover_url 视频封面地址
     */
    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    /**
     * 获取视频标题，可以为空
     *
     * @return title - 视频标题，可以为空
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置视频标题，可以为空
     *
     * @param title 视频标题，可以为空
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取评论总数
     *
     * @return comments_count - 评论总数
     */
    public Long getComments_count() {
        return comments_count;
    }

    /**
     * 设置评论总数
     *
     * @param comments_count 评论总数
     */
    public void setComments_count(Long comments_count) {
        this.comments_count = comments_count;
    }

    /**
     * 获取点赞总数
     *
     * @return favorite_count - 点赞总数
     */
    public Long getFavorite_count() {
        return favorite_count;
    }

    /**
     * 设置点赞总数
     *
     * @param favorite_count 点赞总数
     */
    public void setFavorite_count(Long favorite_count) {
        this.favorite_count = favorite_count;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreated_time() {
        return created_time;
    }

    /**
     * 设置创建时间
     *
     * @param created_time 创建时间
     */
    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    /**
     * 获取更新时间
     *
     * @return updated_time - 更新时间
     */
    public Date getUpdated_time() {
        return updated_time;
    }

    /**
     * 设置更新时间
     *
     * @param updated_time 更新时间
     */
    public void setUpdated_time(Date updated_time) {
        this.updated_time = updated_time;
    }
}