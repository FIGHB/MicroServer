package com.stylefeng.guns.api.user;

import com.stylefeng.guns.api.bean.steve.SteveOrder;
import com.stylefeng.guns.api.bean.steve.SteveOrderInfo;
import com.stylefeng.guns.api.vo.steve.SteveOrderVo;

import java.util.List;

/**
 * @author Steve
 * @date 2019/10/16-20:29
 */
public interface YLOrderService {
    List<SteveOrderVo> getOrderInfo(SteveOrder steveOrder, String username);

    void updateOrderStatus(String uuid,int status);

    SteveOrderInfo getOrderById(String orderId);

    String getFilmName(int filmid);
}
