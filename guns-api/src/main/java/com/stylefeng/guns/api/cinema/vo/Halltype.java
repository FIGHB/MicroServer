package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;

public class Halltype implements Serializable {
    private static final long serialVersionUID = 6721480923936765387L;
    private Integer halltypeId;
    private String halltypeName;
    private Boolean active;

    public Integer getHalltypeId() {
        return halltypeId;
    }

    public void setHalltypeId(Integer halltypeId) {
        this.halltypeId = halltypeId;
    }

    public String getHalltypeName() {
        return halltypeName;
    }

    public void setHalltypeName(String halltypeName) {
        this.halltypeName = halltypeName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Halltype{" +
                "halltypeId=" + halltypeId +
                ", halltypeName='" + halltypeName + '\'' +
                ", active=" + active +
                '}';
    }
}
