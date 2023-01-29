package com.rocky.result;

import java.util.Map;

/**
 * 自定义响应数据类型枚举升级版本
 *
 * @Title: IMOOCJSONResult.java
 * @Package com.rocky.utils
 * @Description: 自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 *
 *
 */
public class GraceJSONResult {

    // 是否成功，1-0
    private Integer status_code;

    // 响应消息
    private String status_msg;

    // 响应数据，可以是Object，也可以是List或Map等
    private Object data;

    /**
     * 成功返回，带有数据的，直接往OK方法丢data数据即可
     * @param data
     * @return
     */
    public static GraceJSONResult ok(Object data) {
        return new GraceJSONResult(data);
    }
    /**
     * 成功返回，不带有数据的，直接调用ok方法，data无须传入（其实就是null）
     * @return
     */
    public static GraceJSONResult ok() {
        return new GraceJSONResult(com.rocky.result.ResponseStatusEnum.SUCCESS);
    }
    public GraceJSONResult(Object data) {
        this.status_code = com.rocky.result.ResponseStatusEnum.SUCCESS.status();
        this.status_msg = com.rocky.result.ResponseStatusEnum.SUCCESS.msg();
        this.data = data;
    }


    /**
     * 错误返回，直接调用error方法即可，当然也可以在ResponseStatusEnum中自定义错误后再返回也都可以
     * @return
     */
    public static GraceJSONResult error() {
        return new GraceJSONResult(com.rocky.result.ResponseStatusEnum.FAILED);
    }

    /**
     * 错误返回，map中包含了多条错误信息，可以用于表单验证，把错误统一的全部返回出去
     * @param map
     * @return
     */
    public static GraceJSONResult errorMap(Map map) {
        return new GraceJSONResult(com.rocky.result.ResponseStatusEnum.FAILED, map);
    }

    /**
     * 错误返回，直接返回错误的消息
     * @param msg
     * @return
     */
    public static GraceJSONResult errorMsg(String msg) {
        return new GraceJSONResult(com.rocky.result.ResponseStatusEnum.FAILED, msg);
    }

    /**
     * 错误返回，token异常，一些通用的可以在这里统一定义
     * @return
     */
    public static GraceJSONResult errorTicket() {
        return new GraceJSONResult(com.rocky.result.ResponseStatusEnum.TICKET_INVALID);
    }

    /**
     * 自定义错误范围，需要传入一个自定义的枚举，可以到[ResponseStatusEnum.java[中自定义后再传入
     * @param responseStatus
     * @return
     */
    public static GraceJSONResult errorCustom(com.rocky.result.ResponseStatusEnum responseStatus) {
        return new GraceJSONResult(responseStatus);
    }
    public static GraceJSONResult exception(com.rocky.result.ResponseStatusEnum responseStatus) {
        return new GraceJSONResult(responseStatus);
    }

    public GraceJSONResult(com.rocky.result.ResponseStatusEnum responseStatus) {
        this.status_code = responseStatus.status();
        this.status_msg = responseStatus.msg();
}
    public GraceJSONResult(com.rocky.result.ResponseStatusEnum responseStatus, Object data) {
        this.status_code = responseStatus.status();
        this.status_msg = responseStatus.msg();
        this.data = data;
    }
    public GraceJSONResult(com.rocky.result.ResponseStatusEnum responseStatus, String status_msg) {
        this.status_code = responseStatus.status();
        this.status_msg = status_msg;
    }

    public GraceJSONResult() {
    }

    public Integer getStatus() {
        return status_code;
    }

    public void setStatus(Integer status) {
        this.status_code = status;
    }

    public String getMsg() {
        return status_msg;
    }

    public void setMsg(String msg) {
        this.status_msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
