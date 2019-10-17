package com.stylefeng.guns.order.common.persistence.dao;

import com.stylefeng.guns.order.common.persistence.model.LRMoocOrderT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author LiRui
 * @since 2019-10-16
 */
public interface LRMoocOrderTMapper extends BaseMapper<LRMoocOrderT> {

    Integer getUserIdByName(String userName);

    LRMoocOrderT selectOrder(String seatsIds, Integer userId);
}
