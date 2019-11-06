package com.stylefeng.guns.film.common.persistence.model;

import java.io.Serializable;

public class CatVO implements Serializable {
    private Integer catId;
    private String catName;
    private boolean active;

    @Override
    public String toString() {
        return "CatVO{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                ", active=" + active +
                '}';
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
