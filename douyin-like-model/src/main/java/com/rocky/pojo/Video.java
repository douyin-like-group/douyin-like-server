package com.rocky.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Video {
    @Id
    private Long id;

    /**
     * 对应用户表id，视频发布者
     */
    private Long uid;

    /**
     * 视频播放地址
     */
    @Column(name = "play_url")
    private String playUrl;

    /**
     * 视频封面地址
     */
    @Column(name = "cover_url")
    private String coverUrl;

    /**
     * 视频标题，可以为空
     */
    private String title;

    /**
     * 评论总数
     */
    @Column(name = "comments_count")
    private Long commentsCount;

    /**
     * 点赞总数
     */
    @Column(name = "favorite_count")
    private Long favoriteCount;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

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
    public String getPlayUrl() {
        return playUrl;
    }

    /**
     * 设置视频播放地址
     *
     * @param playUrl 视频播放地址
     */
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    /**
     * 获取视频封面地址
     *
     * @return cover_url - 视频封面地址
     */
    public String getCoverUrl() {
        return coverUrl;
    }

    /**
     * 设置视频封面地址
     *
     * @param coverUrl 视频封面地址
     */
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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
    public Long getCommentsCount() {
        return commentsCount;
    }

    /**
     * 设置评论总数
     *
     * @param commentsCount 评论总数
     */
    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }

    /**
     * 获取点赞总数
     *
     * @return favorite_count - 点赞总数
     */
    public Long getFavoriteCount() {
        return favoriteCount;
    }

    /**
     * 设置点赞总数
     *
     * @param favoriteCount 点赞总数
     */
    public void setFavoriteCount(Long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新时间
     *
     * @return updated_time - 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}