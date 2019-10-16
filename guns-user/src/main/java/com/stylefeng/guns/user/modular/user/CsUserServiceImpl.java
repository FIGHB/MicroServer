package com.stylefeng.guns.user.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.CsUserService;
import com.stylefeng.guns.api.user.model.UserModel;
import com.stylefeng.guns.api.user.vo.BaseCheckStatusVo;
import com.stylefeng.guns.api.user.vo.BaseRegisterStatusVo;
import com.stylefeng.guns.api.user.vo.BaseVo;
import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.user.common.persistence.dao.CsUserMapper;
import com.stylefeng.guns.user.common.persistence.model.CsUser;
import com.stylefeng.guns.user.modular.user.util.Convert2CsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = CsUserService.class)
public class CsUserServiceImpl implements CsUserService {

    @Autowired
    CsUserMapper csUserMapper;

    @Override
    public BaseVo insert(UserModel userModel) {
        int query = csUserMapper.queryByUsername(userModel.getUsername());
        if(query==1){
            return new BaseVo(BaseRegisterStatusVo.FAIL.getStatus(),BaseRegisterStatusVo.FAIL.getMsg());
        }
        CsUser csUser = Convert2CsUser.convert2CsUser(userModel);
        String encode = MD5Util.encrypt(csUser.getUserPwd());
        csUser.setUserPwd(encode);
        csUserMapper.insert(csUser);
        return new BaseVo(BaseRegisterStatusVo.SUCEED.getStatus(),BaseRegisterStatusVo.SUCEED.getMsg());
    }

    @Override
    public BaseVo check(UserModel userModel) {
        int query = csUserMapper.queryByUsername(userModel.getUsername());
        if(query==1){
            return new BaseVo(BaseCheckStatusVo.FAIL.getStatus(),BaseCheckStatusVo.FAIL.getMsg());
        }
        return new BaseVo(BaseCheckStatusVo.SUCEED.getStatus(),BaseCheckStatusVo.SUCEED.getMsg());
    }

    @Override
    public boolean validate(UserModel userModel) {
        String encrypt = MD5Util.encrypt(userModel.getPassword());
        int i = csUserMapper.queryByUsername(userModel.getUsername());
        if(i==0){
            return false;
        }
        CsUser csUser = csUserMapper.queryPwdByUser(userModel.getUsername());
        if(!encrypt.equals(csUser.getUserPwd())){
            return false;
        }
        return true;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        csUserMapper.updateUser(userInfoModel);
        UserInfoModel userInfo = csUserMapper.selectByUuid(userInfoModel.getUuid());

        return userInfo;
    }
}
