package com.stylefeng.guns.api.cinema.cvo;

import java.io.Serializable;

public class FilmField implements Serializable {
    private static final long serialVersionUID = 7329725035212962672L;
    private String beginTime;
    private String endTime;
    private Integer fieldId;
    private String hallName;
    private String language;
    private String price;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FilmField{" +
                "beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", fieldId=" + fieldId +
                ", hallName='" + hallName + '\'' +
                ", language='" + language + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
