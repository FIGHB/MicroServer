package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;

public class CinemaResult implements Serializable {
    private static final long serialVersionUID = -2973928326224169935L;
    private Integer status;
    private Integer nowPage;
    private Integer totalPage;
    private Object data;
    private String msg;

    private String imgPre;

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
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

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CinemaResult{" +
                "status=" + status +
                ", nowPage=" + nowPage +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }
    public static CinemaResult ok(Object data,Integer nowPage,Integer totalPage){
        CinemaResult cinemaResult = new CinemaResult();
        cinemaResult.setStatus(0);
        cinemaResult.setData(data);
        cinemaResult.setNowPage(nowPage);
        cinemaResult.setTotalPage(totalPage);
        cinemaResult.setImgPre("http://img.meetingshop.cn/");
        return cinemaResult;
    }
    public static CinemaResult businessException(){
        CinemaResult cinemaResult = new CinemaResult();
        cinemaResult.setStatus(1);
        cinemaResult.setMsg("影院信息查询失败");
        return cinemaResult;
    }
    public static CinemaResult SystemException(){
        CinemaResult cinemaResult = new CinemaResult();
        cinemaResult.setStatus(999);
        cinemaResult.setMsg("系统出现异常，请联系管理员");
        return cinemaResult;
    }
}
