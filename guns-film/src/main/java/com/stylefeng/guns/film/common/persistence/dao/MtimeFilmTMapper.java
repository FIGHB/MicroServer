package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.film.common.persistence.model.LRMtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author LiRui
 * @since 2019-10-14
 */

//只要继承了BaseMapper<LRMtimeFilmT> 就可以使用 MP 的各种 crud 功能
@Repository
public interface MtimeFilmTMapper extends BaseMapper<LRMtimeFilmT> {

    List<LRMtimeFilmT> queryBoxRanking(String date);

    List<LRMtimeFilmT> queryExpectRanking();

    List<LRMtimeFilmT> queryHotFilms();

    List<LRMtimeFilmT> querySoonFilms();

    List<LRMtimeFilmT> queryTop100();

    LRMtimeFilmT queryFilmById(int filmId);
}
