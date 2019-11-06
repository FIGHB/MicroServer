package com.stylefeng.guns.api.film;

public interface FilmService {
    Object queryBanners();

    Object queryBoxRanking();

    Object queryExpectRanking();

    Object queryHotFilms();

    Object querySoonFilms();

    Object queryTop100();

    Object getFilmInfoById(String filmId);

    Object getFilmInfoByName(String filmName);
}
