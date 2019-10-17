package com.stylefeng.guns.api.user.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UserInfoModel implements Serializable {
    private static final long serialVersionUID = -1103850605224354506L;

    private int uuid;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private int sex;
    private String birthday;
    private int lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private String createTime;
    private String updateTime;
    private Date beginTime;
    private Date upDateTime;
}
