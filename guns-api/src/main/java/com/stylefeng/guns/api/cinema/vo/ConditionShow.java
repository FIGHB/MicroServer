package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;

public class ConditionShow implements Serializable {
    private static final long serialVersionUID = 8752473332007207163L;
    private  Integer brandId;
    private Integer        hallType;
    private Integer areaId;

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
}
