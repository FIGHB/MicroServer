package com.stylefeng.guns.api.pay.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PayVo implements Serializable {
    private static final long serialVersionUID = 4519045782730346066L;
    private int status;
    private String imgPre;
    private Object data;
    private String msg;

    public PayVo(int status, String imgPre, Object data) {
        this.status = status;
        this.imgPre = imgPre;
        this.data = data;
    }

    public PayVo() {
    }
    public PayVo(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
