package com.stylefeng.guns.cinema.modular.cinema;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.cinema.CWCinemaService;
import com.stylefeng.guns.api.cinema.cvo.*;
import com.stylefeng.guns.cinema.common.persistence.dao.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = CWCinemaService.class)
public class CWCinemaServiceImpl implements CWCinemaService {
    @Autowired
    CinemaMapper cinemaMapper;
    @Override
    public CWInfo queryCWInfo(Integer cinemaId, Integer fieldId) {
        CWInfo cwInfo = new CWInfo();
        FilmInfo filmInfo = cinemaMapper.queryFilmInfo(cinemaId,fieldId);
        CinemaInfo cinemaInfo = cinemaMapper.queryCinemaInfo(cinemaId,fieldId);
       HallInfo hallInfo = cinemaMapper.queryHallInfo(cinemaId,fieldId);
        //filmcat&filmType
        String filmCats = filmInfo.getFilmCats();
        String[] split = filmCats.split("#");
        String cats = new String();
        if (split != null) {
            for (String s : split) {
                String filmCat = cinemaMapper.queryFilmCat(s);
                cats.concat(filmCat + ",");
            }
            if (cats.length() > 0) {
                String substring = cats.substring(0,cats.length() - 1);
                filmInfo.setFilmCats(substring);
            }
        }
        cwInfo.setFilmInfo(filmInfo);
        cwInfo.setCinemaInfo(cinemaInfo);
        cwInfo.setHallInfo(hallInfo);
        return cwInfo;
    }

    /*@Override
    public CWCinemaFields queryCWCinemaFields(Integer cinemaId) {
        CWCinemaFields cwCinemaFields = new CWCinemaFields();
        List<FilmField> filmFields=cinemaMapper.queryCwfilmList();
        cwCinemaFields.setCinemaInfo(cinemaMapper.queryCinemaInfo());
        cwCinemaFields.setFilmList(cinemaMapper.queryCwfilmList());
        //cwCinemaFields.setFilmList(cinemaMapper.queryFilmField());
    }*/
}
