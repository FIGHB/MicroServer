package com.stylefeng.guns.api.order;

public interface LROrderService {

    boolean isTrueSeats(Integer fieldId, String soldSeats);

    Object insertOrder(String username, Integer fieldId, String soldSeats, String seatsName);
}
