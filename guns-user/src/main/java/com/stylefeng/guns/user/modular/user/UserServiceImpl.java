package com.stylefeng.guns.user.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
<<<<<<< HEAD:guns-user/src/main/java/com/stylefeng/guns/rest/modular/user/UserServiceImpl.java
import com.stylefeng.guns.rest.common.persistence.dao.UserMapper;
import com.stylefeng.guns.rest.common.persistence.model.User;
=======
import com.stylefeng.guns.user.common.persistence.dao.UserMapper;
import com.stylefeng.guns.user.common.persistence.model.User;
>>>>>>> 57fccb6f6b4082b624fd15ef1f3c66b881cc1e03:guns-user/src/main/java/com/stylefeng/guns/user/modular/user/UserServiceImpl.java
import com.stylefeng.guns.api.user.UserService;
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
