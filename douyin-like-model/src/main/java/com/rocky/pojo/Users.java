package com.rocky.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Users implements Serializable {
    @Id
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * email
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 关注总数
     */
    @Column(name = "follow_count")
    private Long followCount;

    /**
     * 粉丝总数
     */
    @Column(name = "follower_count")
    private Long followerCount;

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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
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
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取关注总数
     *
     * @return follow_count - 关注总数
     */
    public Long getFollowCount() {
        return followCount;
    }

    /**
     * 设置关注总数
     *
     * @param followCount 关注总数
     */
    public void setFollowCount(Long followCount) {
        this.followCount = followCount;
    }

    /**
     * 获取粉丝总数
     *
     * @return follower_count - 粉丝总数
     */
    public Long getFollowerCount() {
        return followerCount;
    }

    /**
     * 设置粉丝总数
     *
     * @param followerCount 粉丝总数
     */
    public void setFollowerCount(Long followerCount) {
        this.followerCount = followerCount;
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