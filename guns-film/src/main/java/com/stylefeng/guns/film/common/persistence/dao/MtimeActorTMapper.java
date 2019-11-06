package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.film.common.persistence.model.LRDirectorVo;
import com.stylefeng.guns.film.common.persistence.model.MtimeActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author LiRui
 * @since 2019-10-14
 */
public interface MtimeActorTMapper extends BaseMapper<MtimeActorT> {

    LRDirectorVo queryDirectorById(Integer directorId);
}
