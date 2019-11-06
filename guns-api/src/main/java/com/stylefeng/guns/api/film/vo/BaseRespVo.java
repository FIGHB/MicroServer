package com.stylefeng.guns.api.film.vo;

import java.io.Serializable;

/**
 * @Author 赵亚云
 */

public class BaseRespVo<T> implements Serializable {

    private static final long serialVersionUID = 7937214768694547560L;
    private T data;
    private String msg;
    private Integer status;
    private String imPre;
    private Integer nowPage;
    private Integer totalPage;

    public static BaseRespVo ok(Object data, String imPre, Integer nowPage, Integer totalPage){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setData(data);
        baseRespVo.setStatus(0);
        if (imPre!=null){
            baseRespVo.setImPre(imPre);
        }
        if (nowPage!=null){
            baseRespVo.setNowPage(nowPage);
        }
        if (totalPage!=null){
            baseRespVo.setTotalPage(totalPage);
        }
        return baseRespVo;
    }

    @Override
    public String toString() {
        return "BaseRespVo{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", status=" + status +
                ", imPre='" + imPre + '\'' +
                ", nowPage=" + nowPage +
                ", totalPage=" + totalPage +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImPre() {
        return imPre;
    }

    public void setImPre(String imPre) {
        this.imPre = imPre;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
