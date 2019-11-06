package com.stylefeng.guns.api;

import com.stylefeng.guns.api.user.model.UserModel;
import com.stylefeng.guns.api.user.vo.BaseVo;
import com.stylefeng.guns.api.user.vo.UserInfoModel;

public interface CsUserService {

    BaseVo insert(UserModel userModel);

    BaseVo check(UserModel userModel);

    boolean validate(UserModel userModel);

    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);
}
