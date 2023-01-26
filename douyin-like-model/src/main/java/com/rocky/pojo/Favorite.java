package com.rocky.pojo;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

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
     * 关注时间
     */
    private Date create_time;

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
     * 获取关注时间
     *
     * @return create_time - 关注时间
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * 设置关注时间
     *
     * @param create_time 关注时间
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}