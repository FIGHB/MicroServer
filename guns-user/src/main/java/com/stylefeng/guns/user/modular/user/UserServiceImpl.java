package com.stylefeng.guns.user.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.bean.steve.SteveUserforUserInfo;
import com.stylefeng.guns.user.common.persistence.dao.UserMapper;
import com.stylefeng.guns.user.common.persistence.model.User;
import com.stylefeng.guns.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserService.class)    //是 dubbo 的 service 注解
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public SteveUserforUserInfo getUserInfo(String username) {
        SteveUserforUserInfo userInfo = new SteveUserforUserInfo();

        if (username != null){
            userInfo = userMapper.getUserInfo(username);
        }
        return userInfo;
    }
}
