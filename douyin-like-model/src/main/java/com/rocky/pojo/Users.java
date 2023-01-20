package com.rocky.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Users {
    @Id
    private Long id;

    /**
     * 鐢ㄦ埛鍚
     */
    private String username;

    /**
     * 鐢ㄦ埛瀵嗙爜
     */
    private String password;

    /**
     * email
     */
    private String email;

    /**
     * 鎵嬫満鍙风爜
     */
    private String phone;

    /**
     * 鍏虫敞鎬绘暟
     */
    @Column(name = "follow_count")
    private Long followCount;

    /**
     * 绮変笣鎬绘暟
     */
    @Column(name = "follower_count")
    private Long followerCount;

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
     * 获取鐢ㄦ埛鍚
     *
     * @return username - 鐢ㄦ埛鍚
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置鐢ㄦ埛鍚
     *
     * @param username 鐢ㄦ埛鍚
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取鐢ㄦ埛瀵嗙爜
     *
     * @return password - 鐢ㄦ埛瀵嗙爜
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置鐢ㄦ埛瀵嗙爜
     *
     * @param password 鐢ㄦ埛瀵嗙爜
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取email
     *
     * @return email - email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取鎵嬫満鍙风爜
     *
     * @return phone - 鎵嬫満鍙风爜
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置鎵嬫満鍙风爜
     *
     * @param phone 鎵嬫満鍙风爜
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取鍏虫敞鎬绘暟
     *
     * @return follow_count - 鍏虫敞鎬绘暟
     */
    public Long getFollowCount() {
        return followCount;
    }

    /**
     * 设置鍏虫敞鎬绘暟
     *
     * @param followCount 鍏虫敞鎬绘暟
     */
    public void setFollowCount(Long followCount) {
        this.followCount = followCount;
    }

    /**
     * 获取绮変笣鎬绘暟
     *
     * @return follower_count - 绮変笣鎬绘暟
     */
    public Long getFollowerCount() {
        return followerCount;
    }

    /**
     * 设置绮変笣鎬绘暟
     *
     * @param followerCount 绮変笣鎬绘暟
     */
    public void setFollowerCount(Long followerCount) {
        this.followerCount = followerCount;
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