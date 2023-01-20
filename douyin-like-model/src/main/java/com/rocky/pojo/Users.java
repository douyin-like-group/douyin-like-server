package com.rocky.pojo;

import java.util.Date;
import javax.persistence.*;

public class Users {
    @Id
    private Long id;

    /**
     * 閻?劍鍩涢崥锟
     */
    private String username;

    /**
     * 閻?劍鍩涚?鍡欑垳
     */
    private String password;

    /**
     * email
     */
    private String email;

    /**
     * 閹靛?婧?崣椋庣垳
     */
    private String phone;

    /**
     * 閸忚櫕鏁為幀缁樻殶
     */
    @Column(name = "follow_count")
    private Long followCount;

    /**
     * 缁??绗ｉ幀缁樻殶
     */
    @Column(name = "follower_count")
    private Long followerCount;

    /**
     * 閸掓稑缂撻弮鍫曟？
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 閺囧瓨鏌婇弮鍫曟？
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
     * 获取閻?劍鍩涢崥锟
     *
     * @return username - 閻?劍鍩涢崥锟
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置閻?劍鍩涢崥锟
     *
     * @param username 閻?劍鍩涢崥锟
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取閻?劍鍩涚?鍡欑垳
     *
     * @return password - 閻?劍鍩涚?鍡欑垳
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置閻?劍鍩涚?鍡欑垳
     *
     * @param password 閻?劍鍩涚?鍡欑垳
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
     * 获取閹靛?婧?崣椋庣垳
     *
     * @return phone - 閹靛?婧?崣椋庣垳
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置閹靛?婧?崣椋庣垳
     *
     * @param phone 閹靛?婧?崣椋庣垳
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取閸忚櫕鏁為幀缁樻殶
     *
     * @return follow_count - 閸忚櫕鏁為幀缁樻殶
     */
    public Long getFollowCount() {
        return followCount;
    }

    /**
     * 设置閸忚櫕鏁為幀缁樻殶
     *
     * @param followCount 閸忚櫕鏁為幀缁樻殶
     */
    public void setFollowCount(Long followCount) {
        this.followCount = followCount;
    }

    /**
     * 获取缁??绗ｉ幀缁樻殶
     *
     * @return follower_count - 缁??绗ｉ幀缁樻殶
     */
    public Long getFollowerCount() {
        return followerCount;
    }

    /**
     * 设置缁??绗ｉ幀缁樻殶
     *
     * @param followerCount 缁??绗ｉ幀缁樻殶
     */
    public void setFollowerCount(Long followerCount) {
        this.followerCount = followerCount;
    }

    /**
     * 获取閸掓稑缂撻弮鍫曟？
     *
     * @return created_time - 閸掓稑缂撻弮鍫曟？
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置閸掓稑缂撻弮鍫曟？
     *
     * @param createdTime 閸掓稑缂撻弮鍫曟？
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取閺囧瓨鏌婇弮鍫曟？
     *
     * @return updated_time - 閺囧瓨鏌婇弮鍫曟？
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置閺囧瓨鏌婇弮鍫曟？
     *
     * @param updatedTime 閺囧瓨鏌婇弮鍫曟？
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}