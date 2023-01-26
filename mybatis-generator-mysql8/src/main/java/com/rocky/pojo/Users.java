package com.rocky.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Users implements Serializable {
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
    private Long follow_count;

    /**
     * 绮変笣鎬绘暟
     */
    private Long follower_count;

    /**
     * 鍒涘缓鏃堕棿
     */
    private Date created_time;

    /**
     * 鏇存柊鏃堕棿
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
    public Long getFollow_count() {
        return follow_count;
    }

    /**
     * 设置鍏虫敞鎬绘暟
     *
     * @param follow_count 鍏虫敞鎬绘暟
     */
    public void setFollow_count(Long follow_count) {
        this.follow_count = follow_count;
    }

    /**
     * 获取绮変笣鎬绘暟
     *
     * @return follower_count - 绮変笣鎬绘暟
     */
    public Long getFollower_count() {
        return follower_count;
    }

    /**
     * 设置绮変笣鎬绘暟
     *
     * @param follower_count 绮変笣鎬绘暟
     */
    public void setFollower_count(Long follower_count) {
        this.follower_count = follower_count;
    }

    /**
     * 获取鍒涘缓鏃堕棿
     *
     * @return created_time - 鍒涘缓鏃堕棿
     */
    public Date getCreated_time() {
        return created_time;
    }

    /**
     * 设置鍒涘缓鏃堕棿
     *
     * @param created_time 鍒涘缓鏃堕棿
     */
    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    /**
     * 获取鏇存柊鏃堕棿
     *
     * @return updated_time - 鏇存柊鏃堕棿
     */
    public Date getUpdated_time() {
        return updated_time;
    }

    /**
     * 设置鏇存柊鏃堕棿
     *
     * @param updated_time 鏇存柊鏃堕棿
     */
    public void setUpdated_time(Date updated_time) {
        this.updated_time = updated_time;
    }
}