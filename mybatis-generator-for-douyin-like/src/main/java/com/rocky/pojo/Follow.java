package com.rocky.pojo;

import java.util.Date;
import javax.persistence.*;

public class Follow {
    @Id
    private Long id;

    /**
     * 鍙戣捣鍏虫敞鐨勭敤鎴穒d
     */
    @Column(name = "from_id")
    private Long fromId;

    /**
     * 琚叧娉ㄧ殑鐢ㄦ埛id
     */
    @Column(name = "to_id")
    private Long toId;

    /**
     * 浜掑叧涓�1锛屽惁鍒欎负0
     */
    @Column(name = "is_friend")
    private Byte isFriend;

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
     * 获取鍙戣捣鍏虫敞鐨勭敤鎴穒d
     *
     * @return from_id - 鍙戣捣鍏虫敞鐨勭敤鎴穒d
     */
    public Long getFromId() {
        return fromId;
    }

    /**
     * 设置鍙戣捣鍏虫敞鐨勭敤鎴穒d
     *
     * @param fromId 鍙戣捣鍏虫敞鐨勭敤鎴穒d
     */
    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    /**
     * 获取琚叧娉ㄧ殑鐢ㄦ埛id
     *
     * @return to_id - 琚叧娉ㄧ殑鐢ㄦ埛id
     */
    public Long getToId() {
        return toId;
    }

    /**
     * 设置琚叧娉ㄧ殑鐢ㄦ埛id
     *
     * @param toId 琚叧娉ㄧ殑鐢ㄦ埛id
     */
    public void setToId(Long toId) {
        this.toId = toId;
    }

    /**
     * 获取浜掑叧涓�1锛屽惁鍒欎负0
     *
     * @return is_friend - 浜掑叧涓�1锛屽惁鍒欎负0
     */
    public Byte getIsFriend() {
        return isFriend;
    }

    /**
     * 设置浜掑叧涓�1锛屽惁鍒欎负0
     *
     * @param isFriend 浜掑叧涓�1锛屽惁鍒欎负0
     */
    public void setIsFriend(Byte isFriend) {
        this.isFriend = isFriend;
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