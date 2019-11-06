package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import java.util.List;

public class CinemaList implements Serializable {
    private static final long serialVersionUID = -9014110924325609865L;
    List<Cinema> cinemaList;

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    @Override
    public String toString() {
        return "CinemaList{" +
                "cinemaList=" + cinemaList +
                '}';
    }
}
