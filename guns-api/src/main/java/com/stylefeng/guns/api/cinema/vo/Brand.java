package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;

public class Brand implements Serializable {
    private static final long serialVersionUID = -5251469337689572584L;
    private Integer brandId;
    private String brandName;
    private Boolean active;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", active=" + active +
                '}';
    }
}
