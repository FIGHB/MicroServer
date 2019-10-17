package com.alipay.demo.trade.model;

import lombok.Data;

@Data
public class TradeModel {
    private String outTradeNo="0";//必须
    private String subject="meeting电影票支付";//必须
    private String totalAmount="60";//必须
    private String undiscountableAmount;
    private String sellerId;
    private String body;
    private String operatorId="test_operator_id";
    private String storeId="test_store_id";//必须
    private String timeoutExpress="120m";
    public TradeModel(String outTradeNo,String subject,String totalAmount,String storeId){
        this.outTradeNo=outTradeNo;
        this.storeId=storeId;
        this.subject=subject;
        this.totalAmount=totalAmount;
    }

    public TradeModel() {
    }

    public TradeModel(String outTradeNo, String subject, String totalAmount,
                      String undiscountableAmount, String sellerId, String body, String operatorId, String storeId, String timeoutExpress) {
        this.outTradeNo = outTradeNo;
        this.subject = subject;
        this.totalAmount = totalAmount;
        this.undiscountableAmount = undiscountableAmount;
        this.sellerId = sellerId;
        this.body = body;
        this.operatorId = operatorId;
        this.storeId = storeId;
        this.timeoutExpress = timeoutExpress;
    }
}
