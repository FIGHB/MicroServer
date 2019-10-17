package com.stylefeng.guns.order.modular.order;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.stylefeng.guns.api.bean.steve.SteveOrder;
import com.stylefeng.guns.api.bean.steve.SteveOrderInfo;
import com.stylefeng.guns.api.bean.steve.SteveUserForOrder;
import com.stylefeng.guns.api.user.YLOrderService;
import com.stylefeng.guns.api.vo.steve.SteveOrderVo;
import com.stylefeng.guns.order.common.persistence.dao.YLOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steve
 * @date 2019/10/16-20:28
 */
@Component
//注意这里的Service是Dubbo里面的!
@Service(interfaceClass = YLOrderService.class)
public class YLOrderServiceImpl implements YLOrderService {
    @Autowired
    private YLOrderMapper ylOrderMapper;

    @Override
    public List<SteveOrderVo> getOrderInfo(SteveOrder steveOrder, String username) {
        //根据steveOrder分页 根据username查出其他信息
        System.out.println(username);
        System.out.println(steveOrder);
        //首先根据username,查出来userId
        SteveUserForOrder steveUserForOrder = ylOrderMapper.getUserForOrder(username);
        int userId = steveUserForOrder.getUUID();
        //根据当前登录人username获取订单信息


        List<SteveOrderInfo> steveOrderInfoList = null;
        if(userId != 0){
            PageHelper.startPage(steveOrder.getNewPage(),steveOrder.getPageSize());
            steveOrderInfoList = ylOrderMapper.getOrderInfo(userId);
        }
        System.out.println(steveOrderInfoList);

        List<SteveOrderVo> steveOrderVoList = new ArrayList<>();
        if (!steveOrderInfoList.isEmpty()) {
            for (SteveOrderInfo steveOrderInfo : steveOrderInfoList) {
                SteveOrderVo steveOrderVo = new SteveOrderVo();
                //根据steveOrderInfo里面的信息,分别查出和这个订单相关的其他信息
                steveOrderVo.setOrderId(steveOrderInfo.getUUID());

                String filmName = ylOrderMapper.getFilmName(steveOrderInfo.getFilm_id());
                steveOrderVo.setFilmName(filmName);


                String fieldTime = ylOrderMapper.getFieldTime(steveOrderInfo.getField_id());
                steveOrderVo.setFieldTime(fieldTime);

                String cinemaName = ylOrderMapper.getCinemaName(steveOrderInfo.getCinema_id());
                steveOrderVo.setCinemaName(cinemaName);

                steveOrderVo.setSeatsName(steveOrderInfo.getSeats_name());

                steveOrderVo.setOrderPrice(steveOrderInfo.getOrder_price());

                int orderStatusId = steveOrderInfo.getOrder_status();
                String orderStatus = null;
                if (orderStatusId == 0){
                    orderStatus = "待支付";
                }else if(orderStatusId == 1){
                    orderStatus = "已支付";
                } else {
                    orderStatus = "已完成";
                }
                steveOrderVo.setOrderStatus(orderStatus);

                //前面将steveOrderVo里面放上数据以后,然后将其塞进steveOrderVoList中
                steveOrderVoList.add(steveOrderVo);
            }
        }
        return steveOrderVoList;
    }

    @Override
    public void updateOrderStatus(String uuid,int status) {
        //首先要判断一下这个订单号存在不存在
        SteveOrderInfo steveOrderInfo = null;
        if (uuid != null) {
            try {
                steveOrderInfo = ylOrderMapper.selectOrder(uuid);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (steveOrderInfo.getUUID() != null) {
            ylOrderMapper.updateOrderStatus(uuid,status);
        }
    }
}
