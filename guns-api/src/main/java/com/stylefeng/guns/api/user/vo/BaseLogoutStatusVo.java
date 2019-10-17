package com.stylefeng.guns.api.user.vo;

public enum BaseLogoutStatusVo {
    SUCEED (0,"退出成功"),
    FAIL (1,"用户尚未登陆"),
    EXCEPTION (999,"系统出现异常，请联系管理员"),
    ;
    private int status;
    private String msg;

    BaseLogoutStatusVo() {
    }

    BaseLogoutStatusVo(int status, String msg) {
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
