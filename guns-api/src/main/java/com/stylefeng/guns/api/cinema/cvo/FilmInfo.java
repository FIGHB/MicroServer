package com.stylefeng.guns.api.cinema.cvo;

import java.io.Serializable;

public class FilmInfo implements Serializable {
    private static final long serialVersionUID = 2751134431448347661L;
    private String filmId;
    private String filmName;
    private String filmType;
    private String imgAddress;
    private String filmCats;
    private Integer filmLength;

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public Integer getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(Integer filmLength) {
        this.filmLength = filmLength;
    }

    @Override
    public String toString() {
        return "FilmInfo{" +
                "filmId='" + filmId + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmType='" + filmType + '\'' +
                ", imgAddress='" + imgAddress + '\'' +
                ", filmCats='" + filmCats + '\'' +
                ", filmLength=" + filmLength +
                '}';
    }
}
