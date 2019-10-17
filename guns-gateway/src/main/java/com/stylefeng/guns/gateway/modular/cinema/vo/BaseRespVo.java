package com.stylefeng.guns.gateway.modular.cinema.vo;
public class BaseRespVo<T> {
    private T data;
    private int status;
    private String imgPre;


    public static BaseRespVo ok(Object data) {
        BaseRespVo<Object> objectLoginVo = new BaseRespVo<>();
        objectLoginVo.setData(data);
        objectLoginVo.setImgPre("http://img.meetingshop.cn/");
        objectLoginVo.setStatus(0);
        return objectLoginVo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    @Override
    public String toString() {
        return "BaseRespVo{" +
                "data=" + data +
                ", status=" + status +
                ", imgPre='" + imgPre + '\'' +
                '}';
    }
}
