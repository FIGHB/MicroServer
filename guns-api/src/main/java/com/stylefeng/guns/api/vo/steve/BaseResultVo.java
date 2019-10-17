package com.stylefeng.guns.api.vo.steve;

import java.io.Serializable;

/**
 * @author Steve
 * @date 2019/10/14-20:50
 */
public class BaseResultVo<T> implements Serializable {
    private T status;
    private String msg;
    private T data;

    /**
     * 注册成功
     * @return
     */
    public static BaseResultVo ok(Object status, String msg, Object data){
        BaseResultVo<Object> objectBaseResultVo = new BaseResultVo();
        objectBaseResultVo.setStatus(status);
        objectBaseResultVo.setMsg(msg);
        objectBaseResultVo.setData(data);
        return objectBaseResultVo;
    }

    /**
     * 业务异常
     */
    public static BaseResultVo bussinessErr(Object status, String msg){
        BaseResultVo<Object> objectBaseResultVo = new BaseResultVo();
        objectBaseResultVo.setStatus(status);
        objectBaseResultVo.setMsg(msg);
        return objectBaseResultVo;
    }

    /**
     * 系统异常
     */
    public static BaseResultVo systemErr(Object status, String msg){
        BaseResultVo<Object> objectBaseResultVo = new BaseResultVo();
        objectBaseResultVo.setStatus(status);
        objectBaseResultVo.setMsg(msg);
        return objectBaseResultVo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getStatus() {
        return status;
    }

    public void setStatus(T status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
