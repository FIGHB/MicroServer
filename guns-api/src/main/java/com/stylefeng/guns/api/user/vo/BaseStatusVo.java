package com.stylefeng.guns.api.user.vo;

public class  BaseStatusVo {
    private int status;
    private String msg;

    public BaseStatusVo() {
    }

    public BaseStatusVo(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
