package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.film.common.persistence.model.LRDirectorVo;
import com.stylefeng.guns.film.common.persistence.model.MtimeFilmActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 影片与演员映射表 Mapper 接口
 * </p>
 *
 * @author LiRui
 * @since 2019-10-14
 */
public interface MtimeFilmActorTMapper extends BaseMapper<MtimeFilmActorT> {

    List<LRDirectorVo> queryActorListsByFilmId(int filmId);
}
