package com.stylefeng.guns.gateway.modular.film;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.gateway.common.persistence.model.HomePageResponseVo;
import com.stylefeng.guns.rest.film.FilmService;
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

    
}
