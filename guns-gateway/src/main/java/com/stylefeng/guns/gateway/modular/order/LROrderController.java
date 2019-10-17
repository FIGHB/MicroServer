package com.stylefeng.guns.gateway.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.order.LROrderService;
import com.stylefeng.guns.gateway.common.persistence.model.HomePageResponseVo;
import com.stylefeng.guns.gateway.modular.auth.util.JwtTokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LROrderController {
    @Reference(interfaceClass = LROrderService.class,check = false)
    LROrderService orderService;

    @RequestMapping("/order/buyTickets")
    public HomePageResponseVo BuyTickets(HttpServletRequest request,
                                         Integer fieldId, String soldSeats, String seatsName) {
//        String authToken = (String) request.getAttribute("token");
//        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
//        String username = jwtTokenUtil.getUsernameFromToken(authToken);
//        if(username == null || username.equals("")) {
//            return HomePageResponseVo.err(500, "请登录");
//        }
        String username = "admin";
        //1.认证作为信息是否正确
        boolean flag = orderService.isTrueSeats(fieldId, soldSeats);
        //2.创建订单信息，向数据库内添加数据

        if(flag) {
            Object data = orderService.insertOrder(username, fieldId, soldSeats, seatsName);
            return HomePageResponseVo.ok(data);
        }
        return HomePageResponseVo.err(999, "系统出现异常，请联系管理员");
    }
}
