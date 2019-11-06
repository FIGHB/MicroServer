package com.stylefeng.guns.gateway.modular.auth.validator.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.CsUserService;
import com.stylefeng.guns.api.user.model.UserModel;
import com.stylefeng.guns.gateway.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.gateway.modular.auth.validator.dto.Credence;
import org.springframework.stereotype.Service;

/**
 * 账号密码验证
 *
 * @author fengshuonan
 * @date 2017-08-23 12:34
 */
@Service
public class CsUserValidator implements IReqValidator {

    @Reference(interfaceClass = CsUserService.class)
    CsUserService csUserService;

    @Override
    public boolean validate(Credence credence) {
        UserModel userModel = new UserModel();
        userModel.setUsername(credence.getCredenceName());
        userModel.setPassword(credence.getCredenceCode());
        return csUserService.validate(userModel);
    }
}
