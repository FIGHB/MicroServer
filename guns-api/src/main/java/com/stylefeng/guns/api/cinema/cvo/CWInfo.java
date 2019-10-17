package com.stylefeng.guns.api.cinema.cvo;

import java.io.Serializable;

public class CWInfo implements Serializable {
    private static final long serialVersionUID = -1378137285554549997L;
    FilmInfo filmInfo;
    CinemaInfo cinemaInfo;
    HallInfo hallInfo;

    public FilmInfo getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(FilmInfo filmInfo) {
        this.filmInfo = filmInfo;
    }

    public CinemaInfo getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(CinemaInfo cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public HallInfo getHallInfo() {
        return hallInfo;
    }

    public void setHallInfo(HallInfo hallInfo) {
        this.hallInfo = hallInfo;
    }

    @Override
    public String toString() {
        return "CWInfo{" +
                "filmInfo=" + filmInfo +
                ", cinemaInfo=" + cinemaInfo +
                ", hallInfo=" + hallInfo +
                '}';
    }
}
