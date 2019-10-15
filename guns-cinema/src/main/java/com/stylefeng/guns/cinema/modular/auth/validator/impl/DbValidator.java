package com.stylefeng.guns.cinema.modular.auth.validator.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.cinema.common.persistence.dao.UserMapper;
<<<<<<< HEAD:guns-cinema/src/main/java/com/stylefeng/guns/cinema/modular/auth/validator/impl/DbValidator.java
import com.stylefeng.guns.cinema.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.cinema.modular.auth.validator.dto.Credence;
import com.stylefeng.guns.cinema.common.persistence.model.User;
=======
import com.stylefeng.guns.cinema.common.persistence.model.User;
import com.stylefeng.guns.cinema.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.cinema.modular.auth.validator.dto.Credence;
>>>>>>> 57fccb6f6b4082b624fd15ef1f3c66b881cc1e03:guns-cinema/src/main/java/com/stylefeng/guns/rest/modular/auth/validator/impl/DbValidator.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号密码验证
 *
 * @author fengshuonan
 * @date 2017-08-23 12:34
 */
@Service
public class DbValidator implements IReqValidator {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean validate(Credence credence) {
        List<User> users = userMapper.selectList(new EntityWrapper<User>().eq("userName", credence.getCredenceName()));
        if (users != null && users.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
