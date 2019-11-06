package com.stylefeng.guns.gateway.modular.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.pay.OrderQueryModel;
import com.stylefeng.guns.api.pay.PayService;
import com.stylefeng.guns.api.pay.vo.PayData;
import com.stylefeng.guns.api.pay.vo.PayVo;
import com.stylefeng.guns.api.user.UserService;
import com.stylefeng.guns.api.user.YLOrderService;
import com.stylefeng.guns.api.user.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Reference(interfaceClass = PayService.class)
    private PayService payService;

    @Reference(interfaceClass = YLOrderService.class)
    private YLOrderService ylOrderService;


    @RequestMapping("/order/getPayInfo")
    public PayVo getPayInfo(PayData payData){
        PayVo payVo = payService.getPayInfo(payData.getOrderId());
        return payVo;
    }

    @RequestMapping("/order/getPayResult")
    public BaseVo getPayResult(OrderQueryModel orderQueryModel){
        if(orderQueryModel.getTryNums()!=null&&orderQueryModel.getTryNums() >12){
            ylOrderService.updateOrderStatus(orderQueryModel.getOrderId(),2);
            return new BaseVo(1,"订单已关闭");
        }
        BaseVo baseVo = payService.getPayResult(orderQueryModel.getOrderId(),orderQueryModel.getTryNums());
        return baseVo;
    }
}
