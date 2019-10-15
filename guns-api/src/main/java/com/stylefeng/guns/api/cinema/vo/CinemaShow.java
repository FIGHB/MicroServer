package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;

public class CinemaShow implements Serializable {
    private static final long serialVersionUID = 1495243976403930782L;
    private  Integer brandId;
    private Integer        hallType;
   private Integer areaId;
   private Integer PageSize;
   private Integer nowPage;
   private String hallIds;

    public String getHallIds() {
        return hallIds;
    }

    public void setHallIds(String hallIds) {
        this.hallIds = hallIds;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getHallType() {
        return hallType;
    }

    public void setHallType(Integer hallType) {
        this.hallType = hallType;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "CinemaShow{" +
                "brandId=" + brandId +
                ", hallType=" + hallType +
                ", areaId=" + areaId +
                '}';
    }
}
