package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import java.util.List;

public class Fields implements Serializable {
    private static final long serialVersionUID = -3323803729604815465L;
    private Cinema cinemaInfo;
    private List<FilmInfo> filmList;

    public Cinema getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(Cinema cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public List<FilmInfo> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<FilmInfo> filmList) {
        this.filmList = filmList;
    }
}
