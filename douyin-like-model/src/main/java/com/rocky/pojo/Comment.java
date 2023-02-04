package com.rocky.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Comment implements Serializable {
    @Id
    private Long id;

    /**
     * 发布留言的用户id
     */
    private Long uid;

    /**
     * 评论的视频作者id
     */
    private Long vid;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 留言时间
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
     * 获取发布留言的用户id
     *
     * @return uid - 发布留言的用户id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置发布留言的用户id
     *
     * @param uid 发布留言的用户id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取评论的视频作者id
     *
     * @return vid - 评论的视频作者id
     */
    public Long getVid() {
        return vid;
    }

    /**
     * 设置评论的视频作者id
     *
     * @param vid 评论的视频作者id
     */
    public void setVid(Long vid) {
        this.vid = vid;
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
     * 获取留言时间
     *
     * @return create_time - 留言时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置留言时间
     *
     * @param createTime 留言时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}