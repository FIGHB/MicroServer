package com.stylefeng.guns.api.pay.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PayData implements Serializable {
    private static final long serialVersionUID = -5099097150983116516L;
    private String orderId;
    private String QRCodeAddress;

    public PayData(String orderId, String QRCodeAddress) {
        this.orderId = orderId;
        this.QRCodeAddress = QRCodeAddress;
    }

    public PayData() {
    }
}
