package com.stylefeng.guns.gateway.modular.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceZhao;
import com.stylefeng.guns.api.film.vo.BaseRespVo;
import com.stylefeng.guns.api.film.vo.FilmRequestInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class FilmControllerZhao {

    @Reference(check = false)
    FilmServiceZhao filmServiceZhao;

   @RequestMapping("/film/getConditionList")
    public BaseRespVo getConditionList(Integer catId, Integer sourceId, Integer yearId){
       HashMap conditionList = filmServiceZhao.getConditionList(catId, sourceId, yearId);
       return BaseRespVo.ok(conditionList,null,null,null);
   }

   @RequestMapping("/film/getFilms")
    public BaseRespVo getFilms(FilmRequestInfo filmRequestInfo){
       return filmServiceZhao.getFilms(filmRequestInfo);
   }
}
