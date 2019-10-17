package com.stylefeng.guns.api.user.vo;

import lombok.Data;

import java.io.Serializable;


public class BaseVo implements Serializable {
    private static final long serialVersionUID = -8725357634293444987L;
    private int status;
    private Object data;
    private String msg;
    public BaseVo() {
    }

    public BaseVo(int status, Object data) {
        this.status = status;
        this.data = data;
    }
    public BaseVo(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
