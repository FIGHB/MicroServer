package com.stylefeng.guns.api.user.vo;

public enum BaseRegisterStatusVo {
    SUCEED (0,"注册成功"),
    FAIL (1,"用户已存在"),
    EXCEPTION (999,"系统出现异常，请联系管理员"),
    ;
    private int status;
    private String msg;

    BaseRegisterStatusVo() {
    }

    BaseRegisterStatusVo(int status, String msg) {
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
