package com.stylefeng.guns.cinema.common.persistence.dao;

import com.stylefeng.guns.api.cinema.cvo.CinemaInfo;
import com.stylefeng.guns.api.cinema.cvo.FilmInfo;
import com.stylefeng.guns.api.cinema.cvo.HallInfo;

import java.util.List;

public interface CinemaMapper {
    FilmInfo queryFilmInfo(Integer cinemaId, Integer fieldId);

    CinemaInfo queryCinemaInfo(Integer cinemaId, Integer fieldId);

   HallInfo queryHallInfo(Integer cinemaId, Integer fieldId);

    String queryFilmCat(String s);
}
