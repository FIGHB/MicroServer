package com.stylefeng.guns.api.pay.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderStatus implements Serializable {
    private static final long serialVersionUID = 7492617316756196865L;
    private String orderId;
    private int orderStatus;
    private String orderMsg;

    public OrderStatus() {
    }

    public OrderStatus(String orderId, int orderStatus, String orderMsg) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderMsg = orderMsg;
    }
}
