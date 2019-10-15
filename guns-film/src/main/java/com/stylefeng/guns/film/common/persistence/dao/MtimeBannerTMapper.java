package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.film.common.persistence.model.MtimeBannerT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * banner信息表 Mapper 接口
 * </p>
 *
 * @author LiRui
 * @since 2019-10-14
 */

@Repository
public interface MtimeBannerTMapper extends BaseMapper<MtimeBannerT> {

    List<MtimeBannerT> queryAllBanners();
}
