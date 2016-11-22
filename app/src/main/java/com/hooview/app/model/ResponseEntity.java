package com.hooview.app.model;

/**
 * Created by yinyongliang on 16/11/17.
 * 服务器返回的数据底层封装
 */
public class ResponseEntity<T> {

    private int success;
    private long timeStamp;
    private String description;

    /**
     * 占坑，errorCode
     */
    private String errorCode;
    private T responsedata;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public T getResponsedata() {
        return responsedata;
    }

    public void setResponsedata(T responsedata) {
        this.responsedata = responsedata;
    }
}
