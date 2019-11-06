package com.stylefeng.guns.film.common.persistence.model;

import java.io.Serializable;

public class LRDirectorVo implements Serializable {
    private static final long serialVersionUID = 1771841508935687169L;
    private String directorName;
    private String imgAddress;
    private String roleName;

    LRDirectorVo() {
        this.roleName = "";
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
