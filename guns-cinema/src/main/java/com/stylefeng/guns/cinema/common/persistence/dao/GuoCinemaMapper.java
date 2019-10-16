package com.stylefeng.guns.cinema.common.persistence.dao;

import com.stylefeng.guns.api.cinema.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuoCinemaMapper {
    List<Cinema> getCinemaListByDetail(@Param("cinemaShow") CinemaShow cinemaShow);

    List<Brand> getBrandList();

    List<Area> getAreaList();

    List<Halltype> getHalltypeList();

    Cinema getCinemaInfoById(@Param("cinemaId") Integer cinemaId);

    List<FilmField> getFieldByCinemaId(@Param("cinemaId") Integer cinemaId);

    FilmInfo getFilmInfoByFilmId(@Param("filmId") Integer filmId);

    FilmInfo getFilmLength(@Param("filmId") Integer filmId);
}
