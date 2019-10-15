package com.stylefeng.guns.gateway.common.persistence.model;

/**
 * 返回json的bean
 * @author 李锐
 */
public class HomePageResponseVo {
    private Object data;
    private String imgPre;
    private String msg;
    private String nowPage;
    private Integer status;
    private String totalPage;

    public static HomePageResponseVo ok(Object data) {
        HomePageResponseVo responseVo = new HomePageResponseVo();
        responseVo.setData(data);
        responseVo.setImgPre("http://img.meetingshop.cn/");
        responseVo.setMsg("");
        responseVo.setNowPage("");
        responseVo.setStatus(0);
        responseVo.setTotalPage("");
        return responseVo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

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

    public String getNowPage() {
        return nowPage;
    }

    public void setNowPage(String nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }


}
