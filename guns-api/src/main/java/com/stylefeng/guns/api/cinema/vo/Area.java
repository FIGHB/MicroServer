package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;

public class Area implements Serializable {
    private static final long serialVersionUID = 7991290736367957348L;
    private Integer areaId;
    private String areaName;
    private Boolean active;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", active=" + active +
                '}';
    }
}
