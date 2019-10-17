package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.BaseRespVo;
import com.stylefeng.guns.api.film.vo.FilmRequestInfo;

import java.util.HashMap;

/**
 * @author 赵亚云
 */
public interface FilmServiceZhao {
    HashMap getConditionList(Integer catId, Integer sourceId, Integer yearId);
    BaseRespVo getFilms(FilmRequestInfo filmRequestInfo);
}
