package com.stylefeng.guns.api.film.vo;

import java.io.Serializable;

public class FilmResponseInfo implements Serializable {
    private static final long serialVersionUID = -2673352883756201409L;
    //UUID
    private Integer filmId;
    //film_type 片源类型: 0-2D,1-3D,2-3DIMAX,4-无   表mtime_film_t
    private Integer filmType;
    //img_address 影片主图地址  表mtime_film_t
    private String imgAddress;
    //film_name
    private String filmName;
    //film_score
    private String filmScore;

    @Override
    public String toString() {
        return "FilmResponseInfo{" +
                "filmId=" + filmId +
                ", filmType=" + filmType +
                ", imgAddress='" + imgAddress + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmScore='" + filmScore + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getFilmType() {
        return filmType;
    }

    public void setFilmType(Integer filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }

    public FilmResponseInfo() {
    }
}
