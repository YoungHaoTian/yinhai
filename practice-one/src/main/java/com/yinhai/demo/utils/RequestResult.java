package com.yinhai.demo.utils;


public class RequestResult {
    private Integer code;
    private Object data;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static RequestResult success(Object data, String message) {
        return new RequestResult(200, data, message);
    }

    public static RequestResult fail(Object data, String message) {
        return new RequestResult(100, data, message);
    }

    private RequestResult(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
