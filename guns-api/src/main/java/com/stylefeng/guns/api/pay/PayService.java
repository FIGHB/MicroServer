package com.stylefeng.guns.api.pay;

import com.stylefeng.guns.api.pay.vo.PayVo;
import com.stylefeng.guns.api.user.vo.BaseVo;

public interface PayService {
    PayVo getPayInfo(String orderId);

    BaseVo getPayResult(String orderId);
}
