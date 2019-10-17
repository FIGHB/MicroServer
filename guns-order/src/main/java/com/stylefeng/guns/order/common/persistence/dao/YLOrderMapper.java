package com.stylefeng.guns.order.common.persistence.dao;

import com.stylefeng.guns.api.bean.steve.SteveOrderInfo;
import com.stylefeng.guns.api.bean.steve.SteveUserForOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-23
 */
public interface YLOrderMapper  {

    SteveUserForOrder getUserForOrder(@Param("username") String username);

    List<SteveOrderInfo> getOrderInfo(@Param("userId") int userId);

    String getFilmName(@Param("uuid") int film_id);

    String getFieldTime(@Param("uuid") int field_id);

    String getCinemaName(@Param("uuid") int cinema_id);


    SteveOrderInfo selectOrder(@Param("uuid") String uuid);

    void updateOrderStatus(@Param("uuid") String uuid,@Param("status") int status);
}

