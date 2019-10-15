package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.film.common.persistence.model.MtimeSourceDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 区域信息表 Mapper 接口
 * </p>
 *
 * @author LiRui
 * @since 2019-10-14
 */
public interface MtimeSourceDictTMapper extends BaseMapper<MtimeSourceDictT> {

    String queryAreaById(Integer areaId);
}
