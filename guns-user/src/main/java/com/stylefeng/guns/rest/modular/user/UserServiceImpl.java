package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.UserMapper;
import com.stylefeng.guns.rest.common.persistence.model.User;
import com.stylefeng.guns.rest.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserService.class)    //是 dubbo 的 service 注解
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //示例
    @Override
    public String getNameById(int userId) {

        User user = userMapper.selectById(userId);
        return user.getUserName();
    }
}
