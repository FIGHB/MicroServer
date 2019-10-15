package com.stylefeng.guns.film.modular.film;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.film.common.persistence.dao.*;
import com.stylefeng.guns.film.common.persistence.model.*;
import com.stylefeng.guns.api.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Service(interfaceClass = FilmService.class)    //是 dubbo 的 service 注解
public class FilmServiceImpl implements FilmService {

    @Autowired
    MtimeBannerTMapper bannerTMapper;

    @Autowired
    MtimeFilmTMapper filmTMapper;

    @Autowired
    MtimeFilmInfoTMapper filmInfoTMapper;

    @Autowired
    MtimeCatDictTMapper catDictTMapper;

    @Autowired
    MtimeSourceDictTMapper sourceDictTMapper;

    @Autowired
    MtimeActorTMapper actorTMapper;

    @Autowired
    MtimeFilmActorTMapper filmActorTMapper;

    /**
     * 首页顶部的三张循环图的部分
     * @return
     * done
     */
    @Override
    public Object queryBanners() {
        List<MtimeBannerT> banners = bannerTMapper.queryAllBanners();
        return banners;
    }

    /**
     * 今日票房
     * mtime_film_t     film_box_office     film_time
     * @return
     * done
     */
    @Override
    public Object queryBoxRanking() {
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        dateNowStr = "%" + dateNowStr + "%";
        List<LRMtimeFilmT> filmTs =  filmTMapper.queryBoxRanking(dateNowStr);
        setLRMtimeFilmList(filmTs);
        return filmTs;
    }

    /**
     * 最受期待
     * mtime_film_t     film_preSaleNum
     * @return
     * done
     */
    @Override
    public Object queryExpectRanking() {
        List<LRMtimeFilmT> filmTs =  filmTMapper.queryExpectRanking();
        setLRMtimeFilmList(filmTs);

        return filmTs;
    }

    /**
     * 正在热映
     * @return
     * done
     */
    @Override
    public Object queryHotFilms() {
        Map<String, Object> map = new HashMap<>();
        List<LRMtimeFilmT> films =  filmTMapper.queryHotFilms();
        setLRMtimeFilmList(films);
        map.put("filmInfo", films);
        map.put("filmNum", films.size());
        map.put("nowPage", "");
        map.put("totalPage", "");
        return map;
    }

    /**
     * 即将上映
     * @return
     * done
     */
    @Override
    public Object querySoonFilms() {
        Map<String, Object> map = new HashMap<>();
        List<LRMtimeFilmT> films =  filmTMapper.querySoonFilms();
        setLRMtimeFilmList(films);
        map.put("filmInfo", films);
        map.put("filmNum", films.size());
        map.put("nowPage", " ");
        map.put("totalPage", " ");
        return map;
    }

    /**
     * top100
     * mtime_film_t     film_score
     * @return
     * done
     */
    @Override
    public Object queryTop100() {
        List<LRMtimeFilmT> films =  filmTMapper.queryTop100();
        setLRMtimeFilmList(films);
        return films;
    }

    @Override
    public Object getFilmInfoById(String filmId) {
        LRFilmDetailsVo filmDetails = filmInfoTMapper.queryFilmInfoById(filmId);
        LRMtimeFilmT films = filmTMapper.queryFilmById(Integer.parseInt(filmId));
        filmDetails.setFilmName(films.getFilmName());
        filmDetails.setImgAddress(films.getImgAddress());
        filmDetails.setTotalBox(films.getBoxNum().toString());
        setFilmDetailsInfo(filmDetails, films);
        return filmDetails;
    }


    private void setFilmDetailsInfo(LRFilmDetailsVo filmDetails, LRMtimeFilmT films) {
        //info01
        String filmCats = films.getFilmCats();
        String[] catIds = filmCats.split("#");
        StringBuffer info01 = new StringBuffer();
        for (String catId : catIds) {
            if(catId == null || catId.equals("")) {
                continue;
            }
            int id = Integer.parseInt(catId);
            String name = catDictTMapper.queryNameById(id);
            info01.append(name).append(",");
        }
        String subInfo01 = info01.substring(0, info01.length() - 1);
        filmDetails.setInfo01(subInfo01);

        //info02    info02: "法国 / 543分钟"
        String area = sourceDictTMapper.queryAreaById(films.getFilmArea());
        Integer filmLength = filmInfoTMapper.getFilmLengthById(films.getFilmId());
        String info02 =area +  " / " + filmLength.toString();
        filmDetails.setInfo02(info02);

        //info03    info03: "2018-07-19 00:00:00法国上映"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(films.getFilmTime());
        String info03 = dateNowStr + " " + area + "上映";
        filmDetails.setInfo03(info03);

        //info04
        FilmInfo04Vo info04 = filmDetails.getInfo04();
        String[] imgVo = filmDetails.getFilmImgs().split(",");
        Map<String, Object> imgVoMap = new HashMap<>();
        for(int i = 0; i < imgVo.length; i++) {
            if(i == 0) {
                imgVoMap.put("mainImg", imgVo[i]);
            } else {
                imgVoMap.put("img0" + i, imgVo[i]);
            }
        }
        HashMap<Object, Object> actors = new HashMap<>();
        LRDirectorVo director = actorTMapper.queryDirectorById(filmDetails.getDirectorId());

        int filmId = Integer.parseInt(filmDetails.getFilmId());
        List<LRDirectorVo> actorsList = filmActorTMapper.queryActorListsByFilmId(filmId);
        actors.put("director", director);
        actors.put("actors", actorsList);
        info04.setImgVO(imgVoMap);
        info04.setActors(actors);

    }

    @Override
    public Object getFilmInfoByName(String filmName) {
        return null;
    }

    /***************************私有方法**********************************/
    private void setLRMtimeFilmList(List<LRMtimeFilmT> filmTs) {
        for (LRMtimeFilmT film : filmTs) {
            film.setShowTime(film.getFilmTime());
            film.setScore(film.getFilmScore());
            film.setFilmLength(""); //可以去 mtime_film_info_t 中查询但是非必须
        }
    }
}
