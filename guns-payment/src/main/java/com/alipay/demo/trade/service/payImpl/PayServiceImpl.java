package com.alipay.demo.trade.service.payImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alipay.demo.trade.utils.PayMain;
import com.alipay.demo.trade.model.TradeModel;
import com.stylefeng.guns.api.bean.steve.SteveOrderInfo;
import com.stylefeng.guns.api.pay.PayService;
import com.stylefeng.guns.api.pay.vo.OrderStatus;
import com.stylefeng.guns.api.pay.vo.PayData;
import com.stylefeng.guns.api.pay.vo.PayVo;
import com.stylefeng.guns.api.user.YLOrderService;
import com.stylefeng.guns.api.user.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = PayService.class)
public class PayServiceImpl implements PayService {

    @Value("${MicroServer.png.url}")
    private String url;

    @Autowired
    private PayMain payMain;

    @Reference(interfaceClass = YLOrderService.class)
    private YLOrderService ylOrderService;

    @Override
    public PayVo getPayInfo(String orderId) {
        if(orderId==null){
            return new PayVo(1,"订单号不能为空");
        }
        TradeModel tradeModel = new TradeModel();
        tradeModel.setOutTradeNo(orderId);
        SteveOrderInfo orderById = ylOrderService.getOrderById(orderId);
        tradeModel.setTotalAmount(orderById.getOrder_price()+"");
        tradeModel.setSubject(ylOrderService.getFilmName(orderById.getFilm_id()));
        String png = payMain.tradePrecreate(tradeModel);
        if(png==null){
            return new PayVo(1,"订单支付失败，请稍后重试");
        }
        PayData payData = new PayData(orderId, png);
        return new PayVo(0,url,payData);
    }

    @Override
    public BaseVo getPayResult(String orderId) {
        int i = payMain.tradeQuery(orderId);
        if(i==0){
            OrderStatus orderStatus = new OrderStatus(orderId, 1, "支付成功");
            ylOrderService.updateOrderStatus(orderId,1);
            return new BaseVo(0,orderStatus);
        }else if(i==1){
            ylOrderService.updateOrderStatus(orderId,0);
            return new BaseVo(1,"订单支付失败，请稍后重试");
        }else {
            return new BaseVo(999,"系统异常，请联系管理员");
        }
    }
}
