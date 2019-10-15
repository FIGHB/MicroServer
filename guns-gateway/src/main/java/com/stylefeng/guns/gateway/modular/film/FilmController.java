package com.stylefeng.guns.gateway.modular.film;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.gateway.common.persistence.model.HomePageResponseVo;
import com.stylefeng.guns.api.film.FilmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class FilmController {
    @Reference(interfaceClass = FilmService.class)
    private FilmService filmService;

    @RequestMapping("/test")
    public String test() {
        return "ok";
    }

    @RequestMapping("/film/getIndex")
    public HomePageResponseVo getFilmIndex() {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("banners",filmService.queryBanners());
        data.put("boxRanking",filmService.queryBoxRanking());
        data.put("expectRanking",filmService.queryExpectRanking());
        data.put("hotFilms",filmService.queryHotFilms());
        data.put("soonFilms",filmService.querySoonFilms());
        data.put("top100",filmService.queryTop100());
        return HomePageResponseVo.ok(data);
    }

    @GetMapping("/film/films/{identifaction}")
    public HomePageResponseVo getFilmInfo(@PathVariable("identifaction")String identifaction,
                                          Integer searchType) {
        Object data = null;
        if(searchType == 0) {
            String filmId = identifaction;
            data = filmService.getFilmInfoById(filmId);
        } else if(searchType == 1) {
            String filmName = identifaction;
            data = filmService.getFilmInfoByName(filmName);
        } else {
            return HomePageResponseVo.err(1, "查询失败，无影片可加载");
        }
        return HomePageResponseVo.ok(data);
    }
}
