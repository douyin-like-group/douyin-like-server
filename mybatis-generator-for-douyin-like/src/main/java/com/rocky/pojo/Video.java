package com.rocky.pojo;

import java.util.Date;
import javax.persistence.*;

public class Video {
    @Id
    private Long id;

    /**
     * 瀵瑰簲鐢ㄦ埛琛╥d锛岃棰戝彂甯冭��
     */
    private Long uid;

    /**
     * 瑙嗛鎾斁鍦板潃
     */
    @Column(name = "play_url")
    private String playUrl;

    /**
     * 瑙嗛灏侀潰鍦板潃
     */
    @Column(name = "cover_url")
    private String coverUrl;

    /**
     * 瑙嗛鏍囬锛屽彲浠ヤ负绌�
     */
    private String title;

    /**
     * 璇勮鎬绘暟
     */
    @Column(name = "comments_count")
    private Long commentsCount;

    /**
     * 鐐硅禐鎬绘暟
     */
    @Column(name = "favorite_count")
    private Long favoriteCount;

    /**
     * 鍒涘缓鏃堕棿
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 鏇存柊鏃堕棿
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
     * 获取瀵瑰簲鐢ㄦ埛琛╥d锛岃棰戝彂甯冭��
     *
     * @return uid - 瀵瑰簲鐢ㄦ埛琛╥d锛岃棰戝彂甯冭��
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置瀵瑰簲鐢ㄦ埛琛╥d锛岃棰戝彂甯冭��
     *
     * @param uid 瀵瑰簲鐢ㄦ埛琛╥d锛岃棰戝彂甯冭��
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取瑙嗛鎾斁鍦板潃
     *
     * @return play_url - 瑙嗛鎾斁鍦板潃
     */
    public String getPlayUrl() {
        return playUrl;
    }

    /**
     * 设置瑙嗛鎾斁鍦板潃
     *
     * @param playUrl 瑙嗛鎾斁鍦板潃
     */
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    /**
     * 获取瑙嗛灏侀潰鍦板潃
     *
     * @return cover_url - 瑙嗛灏侀潰鍦板潃
     */
    public String getCoverUrl() {
        return coverUrl;
    }

    /**
     * 设置瑙嗛灏侀潰鍦板潃
     *
     * @param coverUrl 瑙嗛灏侀潰鍦板潃
     */
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    /**
     * 获取瑙嗛鏍囬锛屽彲浠ヤ负绌�
     *
     * @return title - 瑙嗛鏍囬锛屽彲浠ヤ负绌�
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置瑙嗛鏍囬锛屽彲浠ヤ负绌�
     *
     * @param title 瑙嗛鏍囬锛屽彲浠ヤ负绌�
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取璇勮鎬绘暟
     *
     * @return comments_count - 璇勮鎬绘暟
     */
    public Long getCommentsCount() {
        return commentsCount;
    }

    /**
     * 设置璇勮鎬绘暟
     *
     * @param commentsCount 璇勮鎬绘暟
     */
    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }

    /**
     * 获取鐐硅禐鎬绘暟
     *
     * @return favorite_count - 鐐硅禐鎬绘暟
     */
    public Long getFavoriteCount() {
        return favoriteCount;
    }

    /**
     * 设置鐐硅禐鎬绘暟
     *
     * @param favoriteCount 鐐硅禐鎬绘暟
     */
    public void setFavoriteCount(Long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    /**
     * 获取鍒涘缓鏃堕棿
     *
     * @return created_time - 鍒涘缓鏃堕棿
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置鍒涘缓鏃堕棿
     *
     * @param createdTime 鍒涘缓鏃堕棿
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取鏇存柊鏃堕棿
     *
     * @return updated_time - 鏇存柊鏃堕棿
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置鏇存柊鏃堕棿
     *
     * @param updatedTime 鏇存柊鏃堕棿
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}