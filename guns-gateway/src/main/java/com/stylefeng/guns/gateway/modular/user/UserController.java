package com.stylefeng.guns.gateway.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.user.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference(interfaceClass = UserService.class)
    private UserService userService;

    @RequestMapping("getUsername")
    public String getUsernameById(@Param("id")int id) {
        return userService.getNameById(id);
    }

}
