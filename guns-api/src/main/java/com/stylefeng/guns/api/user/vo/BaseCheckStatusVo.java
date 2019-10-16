package com.stylefeng.guns.api.user.vo;

public enum BaseCheckStatusVo {
    SUCEED (0,"用户名不存在"),
    FAIL (1,"用户已注册"),
    EXCEPTION (999,"系统出现异常，请联系管理员"),
    ;
    private int status;
    private String msg;

    BaseCheckStatusVo() {
    }

    BaseCheckStatusVo(int status, String msg) {
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
