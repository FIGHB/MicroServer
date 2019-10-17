package com.stylefeng.guns.user.modular.user.util;

import com.stylefeng.guns.api.user.model.UserModel;
import com.stylefeng.guns.user.common.persistence.model.CsUser;

public class Convert2CsUser {

    public static CsUser convert2CsUser(UserModel userModel){
        CsUser csUser = new CsUser();
        csUser.setUserName(userModel.getUsername());
        csUser.setUserPwd(userModel.getPassword());
        csUser.setAddress(userModel.getAddress());
        csUser.setEmail(userModel.getEamil());
        csUser.setUserPhone(userModel.getPhone());
        return csUser;
    }
}
