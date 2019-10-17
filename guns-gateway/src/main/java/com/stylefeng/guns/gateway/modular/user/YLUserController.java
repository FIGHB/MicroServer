package com.stylefeng.guns.gateway.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.bean.steve.SteveOrder;
import com.stylefeng.guns.api.bean.steve.SteveUserforUserInfo;
import com.stylefeng.guns.api.user.UserService;
import com.stylefeng.guns.api.user.YLOrderService;
import com.stylefeng.guns.api.vo.steve.BaseResultVo;
import com.stylefeng.guns.api.vo.steve.SteveOrderVo;
import com.stylefeng.guns.gateway.config.properties.JwtProperties;
import com.stylefeng.guns.gateway.modular.auth.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class YLUserController {

    @Reference(interfaceClass = UserService.class)
    private UserService userService;

    @Reference(interfaceClass = YLOrderService.class)
    private YLOrderService ylOrderService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private Jedis jedis;

    @RequestMapping("/user/getUserInfo")
    public BaseResultVo getUserInfo(HttpServletRequest request) {

        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
        }
        String username = jedis.get(authToken);

        SteveUserforUserInfo userInfo;
        try {
            if (username != null) {
                userInfo = userService.getUserInfo(username);
                System.out.println(userInfo);
            } else {
                return BaseResultVo.bussinessErr(1, "查询失败，用户尚未登陆");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResultVo.systemErr(999, "系统出现异常，请联系管理员");
        }

        if (username == null) {
            return BaseResultVo.bussinessErr(1, "查询失败，用户尚未登陆");
        } else {
            return BaseResultVo.ok(0, "", userInfo);
        }
    }

    @RequestMapping("/order/getOrderInfo")
    public BaseResultVo getOrderInfo(SteveOrder steveOrder, HttpServletRequest request) {
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
        }
        String username = jedis.get(authToken);

        List<SteveOrderVo> steveOrderVoList = null;
        try {
            steveOrderVoList = ylOrderService.getOrderInfo(steveOrder,username);
        }catch (Exception e){
            e.printStackTrace();
            return BaseResultVo.systemErr(999,"系统出现异常，请联系管理员");
        }

        if (steveOrderVoList.isEmpty()){
            return BaseResultVo.bussinessErr(1,"订单列表为空哦!");
        }else {
            return BaseResultVo.ok(0, "", steveOrderVoList);
        }
    }
}
