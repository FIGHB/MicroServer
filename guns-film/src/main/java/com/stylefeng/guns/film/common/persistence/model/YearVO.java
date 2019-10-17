package com.stylefeng.guns.film.common.persistence.model;

import java.io.Serializable;

public class YearVO implements Serializable {
    private Integer yearId;
    private String yearName;
    private boolean active;

    public YearVO(Integer yearId, String yearName, boolean active) {
        this.yearId = yearId;
        this.yearName = yearName;
        this.active = active;
    }

    public YearVO() {
    }

    @Override
    public String toString() {
        return "YearVO{" +
                "yearId=" + yearId +
                ", yearName='" + yearName + '\'' +
                ", active=" + active +
                '}';
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
