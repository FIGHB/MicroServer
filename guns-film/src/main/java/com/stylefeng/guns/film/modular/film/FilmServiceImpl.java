package com.stylefeng.guns.film.modular.film;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.film.common.persistence.dao.MtimeBannerTMapper;
import com.stylefeng.guns.film.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.film.common.persistence.model.LRMtimeFilmT;
import com.stylefeng.guns.film.common.persistence.model.MtimeBannerT;
import com.stylefeng.guns.rest.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service(interfaceClass = FilmService.class)    //是 dubbo 的 service 注解
public class FilmServiceImpl implements FilmService {

    @Autowired
    MtimeBannerTMapper bannerTMapper;

    @Autowired
    MtimeFilmTMapper filmTMapper;

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


/***************************私有方法**********************************/
    private void setLRMtimeFilmList(List<LRMtimeFilmT> filmTs) {
        for (LRMtimeFilmT film : filmTs) {
            film.setShowTime(film.getFilmTime());
            film.setScore(film.getFilmScore());
            film.setFilmLength(""); //可以去 mtime_film_info_t 中查询但是非必须
        }
    }
}
