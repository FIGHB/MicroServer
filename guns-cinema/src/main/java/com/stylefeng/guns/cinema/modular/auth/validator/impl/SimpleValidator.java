package com.stylefeng.guns.cinema.modular.auth.validator.impl;

<<<<<<< HEAD
import com.stylefeng.guns.cinema.modular.auth.validator.dto.Credence;
import com.stylefeng.guns.cinema.modular.auth.validator.IReqValidator;
=======
import com.stylefeng.guns.cinema.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.cinema.modular.auth.validator.dto.Credence;
>>>>>>> 57fccb6f6b4082b624fd15ef1f3c66b881cc1e03
import org.springframework.stereotype.Service;

/**
 * 直接验证账号密码是不是admin
 *
 * @author fengshuonan
 * @date 2017-08-23 12:34
 */
@Service
public class SimpleValidator implements IReqValidator {

    private static String USER_NAME = "admin";

    private static String PASSWORD = "admin";

    @Override
    public boolean validate(Credence credence) {

        String userName = credence.getCredenceName();
        String password = credence.getCredenceCode();

        if (USER_NAME.equals(userName) && PASSWORD.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
