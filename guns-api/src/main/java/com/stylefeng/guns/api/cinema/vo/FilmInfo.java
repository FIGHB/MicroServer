package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import java.util.List;

public class FilmInfo implements Serializable {
    private static final long serialVersionUID = 7423915300874907884L;
    private String actors;
    private String filmCats;
    private List<FilmField> filmFields;
    private Integer filmId;
    private String filmLength;
    private String filmName;
    private String filmType;
    private String imgAddress;

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<FilmField> getFilmFields() {
        return filmFields;
    }

    public void setFilmFields(List<FilmField> filmFields) {
        this.filmFields = filmFields;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
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
}
