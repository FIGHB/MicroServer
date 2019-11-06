package com.stylefeng.guns.api.user.vo;

import lombok.Data;

@Data
public class AuthToken {
    private String randomKey;
    private String token;

    public AuthToken(String randomKey, String token) {
        this.randomKey = randomKey;
        this.token = token;
    }
}
