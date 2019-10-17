package com.stylefeng.guns.api.pay;

import lombok.Data;

@Data
public class OrderQueryModel {
    private String orderId;
    private Integer tryNums=1;
}
