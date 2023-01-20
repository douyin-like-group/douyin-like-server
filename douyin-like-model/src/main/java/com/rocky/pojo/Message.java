package com.rocky.pojo;

import java.util.Date;
import javax.persistence.*;

public class Message {
    @Id
    private Long id;

    /**
     * 鍙戦�佽�� id
     */
    private Long uid;

    /**
     * 鎺ュ彈鑰� id
     */
    private Long vid;

    /**
     * 浜掑叧涓�1锛屽惁鍒欎负0
     */
    @Column(name = "is_friend")
    private Byte isFriend;

    /**
     * 鐣欒█鍐呭
     */
    private String content;

    /**
     * 鍏虫敞鏃堕棿
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 0-鏈锛�1-宸茶锛�2-鍒犻櫎
     */
    @Column(name = "message_status")
    private Byte messageStatus;

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
     * 获取鍙戦�佽�� id
     *
     * @return uid - 鍙戦�佽�� id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置鍙戦�佽�� id
     *
     * @param uid 鍙戦�佽�� id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取鎺ュ彈鑰� id
     *
     * @return vid - 鎺ュ彈鑰� id
     */
    public Long getVid() {
        return vid;
    }

    /**
     * 设置鎺ュ彈鑰� id
     *
     * @param vid 鎺ュ彈鑰� id
     */
    public void setVid(Long vid) {
        this.vid = vid;
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

    /**
     * 获取0-鏈锛�1-宸茶锛�2-鍒犻櫎
     *
     * @return message_status - 0-鏈锛�1-宸茶锛�2-鍒犻櫎
     */
    public Byte getMessageStatus() {
        return messageStatus;
    }

    /**
     * 设置0-鏈锛�1-宸茶锛�2-鍒犻櫎
     *
     * @param messageStatus 0-鏈锛�1-宸茶锛�2-鍒犻櫎
     */
    public void setMessageStatus(Byte messageStatus) {
        this.messageStatus = messageStatus;
    }
}