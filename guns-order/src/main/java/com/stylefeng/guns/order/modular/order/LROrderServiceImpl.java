package com.stylefeng.guns.order.modular.order;

import com.alibaba.dubbo.config.annotation.Service;

import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.api.order.LROrderService;
import com.stylefeng.guns.order.common.persistence.dao.*;
import com.stylefeng.guns.order.common.persistence.model.LRMoocOrderT;
import com.stylefeng.guns.order.common.persistence.model.LRMtimeFieldT;
import com.stylefeng.guns.order.common.persistence.model.LRMiddleTableBean;
import com.stylefeng.guns.order.common.persistence.model.LRSeatBean;
import com.stylefeng.guns.order.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Service(interfaceClass = LROrderService.class)
public class LROrderServiceImpl implements LROrderService {

    @Autowired
    LRMoocOrderTMapper moocOrderTMapper;

    @Autowired
    LRMtimeFieldTMapper mtimeFieldTMapper;

    @Autowired
    LRMtimeFilmTMapper filmTMapper;

    @Autowired
    LRMtimeCinemaTMapper cinemaTMapper;

    @Autowired
    LRMtimeHallDictTMapper hallDictTMapper;

    @Override
    public boolean isTrueSeats(Integer fieldId, String soldSeats) {

        return true;
    }

    @Override
    public Object insertOrder(String username, Integer fieldId, String soldSeats, String seatsName) {
        Integer userId = getUserIdByName(username);
        LRMiddleTableBean middleBean = getMiddleTableBean(fieldId);
        ArrayList<Integer> seatsList = getSoldSeatsList(soldSeats);
        LRMoocOrderT lrMoocOrderT = new LRMoocOrderT();
        Double orderPrice = Double.valueOf(seatsList.size() * middleBean.getField().getPrice());

        //获取 座位相关的 json 内容，暂时路径写死
        LRSeatBean seatBean = getLRSeatBeanFromFilePath("json/imax.json");
        //根据 seatsList 从 LRSeatBean 中获取到对应座位的中文表达方式
        String strSeatsName = getStrSeatsName(seatsList, seatBean, seatsName);

        String uuid = UUID.randomUUID().toString();
        //向数据添加订单数据
        lrMoocOrderT.setUuid(uuid);
        lrMoocOrderT.setFieldId(fieldId);
        lrMoocOrderT.setSeatsIds(soldSeats);
        lrMoocOrderT.setSeatsName(strSeatsName);
        lrMoocOrderT.setFilmPrice(Double.valueOf(middleBean.getField().getPrice()));
        lrMoocOrderT.setOrderPrice(orderPrice);
        lrMoocOrderT.setOrderTime(new Date());
        lrMoocOrderT.setOrderUser(userId);
        lrMoocOrderT.setOrderStatus(0);
        lrMoocOrderT.setCinemaId(middleBean.getCinema().getUuid());
        Integer insert = moocOrderTMapper.insert(lrMoocOrderT);
//        LRMoocOrderT moocOrder = moocOrderTMapper.selectOrder(soldSeats, userId);



        //封装返回的数据
        HashMap<String, Object> data = new HashMap<>();
        data.put("orderId", "");
        data.put("filmName", middleBean.getFilm().getFilmName());
        String fieldTime = "今天 " + middleBean.getField().getBeginTime();
        data.put("fieldTime", fieldTime);
        data.put("cinemaName", middleBean.getCinema().getCinemaName());
        data.put("seatsName", strSeatsName);
        data.put("orderPrice", orderPrice);
        data.put("orderTimestamp", lrMoocOrderT.getOrderTime().getTime());
        return data;
    }

    //从座位的数字表达方式转成 几排几座 并拼接成一个字符串
    private String getStrSeatsName(ArrayList<Integer> seatsList, LRSeatBean seatBean, String seatsName) {
        StringBuffer strb = new StringBuffer();
        for (Integer seatId : seatsList) {
            if(seatsName != null && seatsName.equals("单排座")) {
                List<List<Map<String, Integer>>> single = seatBean.getSingle();
                strb.append(getStrSeatsName(seatId, single)).append(",");
            } else if(seatsName != null && seatsName.equals("双排座")) {
                List<List<Map<String, Integer>>> couple = seatBean.getCouple();
                strb.append(getStrSeatsName(seatId, couple)).append(",");
            }
        }
        if(strb.length() > 0) return strb.substring(0, strb.length() - 1);
        return null;
    }

    private String getStrSeatsName(Integer seatId, List<List<Map<String, Integer>>> seatList) {
        for (List<Map<String, Integer>> maps : seatList) {
            for (Map<String, Integer> map : maps) {
                Integer seatId1 = map.get("seatId");
                if(seatId == seatId1) {
                    Integer row = map.get("row");
                    Integer column = map.get("column");
                    return row + "排" + column + "座";
                }
            }
        }
        return null;
    }

    //从 resources 目录下的对应 json 文件中获取座位的相关信息
    private LRSeatBean getLRSeatBeanFromFilePath(String filePath) {
        //获取 座位相关的 json 内容
        String strJson = JsonUtils.readJsonFile("json/imax.json");
        LRSeatBean seatBean = JSON.parseObject(strJson, LRSeatBean.class);
        return seatBean;
    }

    //获取和 mtime_field_t 这张表相关联的表的所有信息，并封装到一个 JAVABean中
    private LRMiddleTableBean getMiddleTableBean(Integer fieldId) {
        LRMiddleTableBean middleBean = new LRMiddleTableBean();
        LRMtimeFieldT fieldT = mtimeFieldTMapper.selectById(fieldId);

        middleBean.setFieldId(fieldId);
        middleBean.setField(fieldT);
        middleBean.setCinema(cinemaTMapper.selectById(fieldT.getCinemaId()));
        middleBean.setFilm(filmTMapper.selectById(fieldT.getFilmId()));
        middleBean.setHallDict(hallDictTMapper.selectById(fieldT.getHallId()));

        return middleBean;
    }

    //根据string 类型的座位信息，拆分成座位的数组返回
    private ArrayList<Integer> getSoldSeatsList(String soldSeats) {
        String[] seats = soldSeats.split(",");
        ArrayList<Integer> seatsList = new ArrayList<>();
        for (String seat : seats) {
            if(seat == null || seat.equals("")) continue;
            seatsList.add(Integer.parseInt(seat));
        }
        return seatsList;
    }

    private Integer getUserIdByName(String userName) {
        return moocOrderTMapper.getUserIdByName(userName);
    }
}
