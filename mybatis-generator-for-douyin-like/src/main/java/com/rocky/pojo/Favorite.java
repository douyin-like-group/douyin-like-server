package com.rocky.pojo;

import java.util.Date;
import javax.persistence.*;

public class Favorite {
    @Id
    private Long id;

    /**
     * 鐢ㄦ埛id
     */
    private Long uid;

    /**
     * 鍠滄鐨勭煭瑙嗛id
     */
    private Long vid;

    /**
     * 鍏虫敞鏃堕棿
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
     * 获取鐢ㄦ埛id
     *
     * @return uid - 鐢ㄦ埛id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置鐢ㄦ埛id
     *
     * @param uid 鐢ㄦ埛id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取鍠滄鐨勭煭瑙嗛id
     *
     * @return vid - 鍠滄鐨勭煭瑙嗛id
     */
    public Long getVid() {
        return vid;
    }

    /**
     * 设置鍠滄鐨勭煭瑙嗛id
     *
     * @param vid 鍠滄鐨勭煭瑙嗛id
     */
    public void setVid(Long vid) {
        this.vid = vid;
    }

    /**
     * 获取鍏虫敞鏃堕棿
     *
     * @return create_time - 鍏虫敞鏃堕棿
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置鍏虫敞鏃堕棿
     *
     * @param createTime 鍏虫敞鏃堕棿
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}