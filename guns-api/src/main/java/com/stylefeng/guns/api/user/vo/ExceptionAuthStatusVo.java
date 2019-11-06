package com.stylefeng.guns.api.user.vo;

public enum ExceptionAuthStatusVo {
    FAIL (1,"用户名或密码错误"),
    EXCEPTION (999,"系统出现异常，请联系管理员"),
    ;
    private int status;
    private String msg;

    ExceptionAuthStatusVo() {
    }

    ExceptionAuthStatusVo(int status, String msg) {
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
