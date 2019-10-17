package com.stylefeng.guns.api.vo.steve;

import java.io.Serializable;

/**
 * @author Steve
 * @date 2019/10/14-22:59
 */
public class LoginVo implements Serializable {
    private String randomKey;
    private String token;

    public String getRandomKey() {
        return randomKey;
    }

    public void setRandomKey(String randomKey) {
        this.randomKey = randomKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
