package com.rocky.pojo;

import java.util.Date;
import javax.persistence.*;

public class Comment {
    @Id
    private Long id;

    /**
     * 鍙戝竷鐣欒█鐨勭敤鎴穒d
     */
    private Long uid;

    /**
     * 璇勮鐨勮棰戜綔鑰卛d
     */
    private Long vid;

    /**
     * 鐣欒█鍐呭
     */
    private String content;

    /**
     * 鐣欒█鏃堕棿
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取鍙戝竷鐣欒█鐨勭敤鎴穒d
     *
     * @return uid - 鍙戝竷鐣欒█鐨勭敤鎴穒d
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置鍙戝竷鐣欒█鐨勭敤鎴穒d
     *
     * @param uid 鍙戝竷鐣欒█鐨勭敤鎴穒d
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取璇勮鐨勮棰戜綔鑰卛d
     *
     * @return vid - 璇勮鐨勮棰戜綔鑰卛d
     */
    public Long getVid() {
        return vid;
    }

    /**
     * 设置璇勮鐨勮棰戜綔鑰卛d
     *
     * @param vid 璇勮鐨勮棰戜綔鑰卛d
     */
    public void setVid(Long vid) {
        this.vid = vid;
    }

    /**
     * 获取鐣欒█鍐呭
     *
     * @return content - 鐣欒█鍐呭
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置鐣欒█鍐呭
     *
     * @param content 鐣欒█鍐呭
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取鐣欒█鏃堕棿
     *
     * @return create_time - 鐣欒█鏃堕棿
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置鐣欒█鏃堕棿
     *
     * @param createTime 鐣欒█鏃堕棿
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}