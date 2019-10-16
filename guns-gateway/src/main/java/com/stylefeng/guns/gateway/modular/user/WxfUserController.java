package com.stylefeng.guns.gateway.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.CsUserService;
import com.stylefeng.guns.api.user.UserService;
import com.stylefeng.guns.api.user.model.UserModel;
import com.stylefeng.guns.api.user.vo.*;
import com.stylefeng.guns.gateway.config.properties.JwtProperties;
import com.stylefeng.guns.gateway.modular.auth.util.JwtTokenUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WxfUserController {

    @Reference(interfaceClass = UserService.class)
    private UserService userService;

    @Reference(interfaceClass = CsUserService.class)
    private CsUserService csUserService;

    @Autowired
    private Jedis jedis;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;



    @RequestMapping("/user/register")
    public BaseVo register(UserModel userModel){
        return csUserService.insert(userModel);
    }

    @RequestMapping("/user/check")
    public BaseVo check( UserModel userModel){
        return csUserService.check(userModel);
    }

    @RequestMapping("/user/logout")
    public BaseVo logout(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        jedis.expire(token,0);
        return new BaseVo(BaseLogoutStatusVo.SUCEED.getStatus(),BaseLogoutStatusVo.SUCEED.getMsg());
    }

    @RequestMapping("/user/updateUserInfo")
    public BaseVo updateUserInfo(UserInfoModel userInfoModel,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(token);
        userInfoModel.setUsername(usernameFromToken);
        UserInfoModel userInfo = csUserService.updateUserInfo(userInfoModel);
        if(userInfo!=null){
            return new BaseVo(0,userInfo);
        }else {
            return new BaseVo(1, "用户信息修改失败");
        }
    }
}
