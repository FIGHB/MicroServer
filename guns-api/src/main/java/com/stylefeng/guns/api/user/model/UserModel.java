package com.stylefeng.guns.api.user.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserModel implements Serializable {
    private static final long serialVersionUID = 2402462885815552342L;
    private String username;
    private String password;
    private String eamil;
    private String phone;
    private String address;
}
