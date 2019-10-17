package com.stylefeng.guns.api.cinema.cvo;

import java.io.Serializable;
import java.util.List;

public class CWCinemaFields implements Serializable {
    private static final long serialVersionUID = -9106037295933834485L;
    CinemaInfo cinemaInfo;
    List<CWFilm> filmList;

    public CinemaInfo getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(CinemaInfo cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public List<CWFilm> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<CWFilm> filmList) {
        this.filmList = filmList;
    }
}
