package com.example.androiddome.retrofit;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/2/28 18:08
 * Description:
 */
public class Data<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
