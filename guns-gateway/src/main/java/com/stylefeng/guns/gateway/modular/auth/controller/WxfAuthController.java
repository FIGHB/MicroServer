package com.stylefeng.guns.gateway.modular.auth.controller;

import com.stylefeng.guns.api.user.vo.AuthToken;
import com.stylefeng.guns.api.user.vo.BaseVo;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.gateway.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.gateway.common.exception.BizExceptionEnum;
import com.stylefeng.guns.gateway.modular.auth.controller.dto.AuthRequest;

import com.stylefeng.guns.gateway.modular.auth.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class WxfAuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private Jedis jedis;


    @Resource(name = "csUserValidator")
    private IReqValidator reqValidator;

    @RequestMapping(value = "${jwt.auth-path}")
    public BaseVo createAuthenticationToken(AuthRequest authRequest) {

        boolean validate = reqValidator.validate(authRequest);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
            jedis.set(token,authRequest.getUserName());
            jedis.expire(token,604800);
            return new BaseVo(0,new AuthToken(randomKey,token));
        } else {
            throw new GunsException(BizExceptionEnum.AUTH_REQUEST_ERROR);
        }
    }
}
