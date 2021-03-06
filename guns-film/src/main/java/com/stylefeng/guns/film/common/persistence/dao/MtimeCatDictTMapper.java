package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.film.common.persistence.model.MtimeCatDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 类型信息表 Mapper 接口
 * </p>
 *
 * @author LiRui
 * @since 2019-10-14
 */
public interface MtimeCatDictTMapper extends BaseMapper<MtimeCatDictT> {

    String queryNameById(int id);
}
