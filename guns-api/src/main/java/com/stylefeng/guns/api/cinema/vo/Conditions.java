package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import java.util.List;

public class Conditions implements Serializable {
    private static final long serialVersionUID = -2920699309502133394L;
    private List<Brand> brandList;
    private List<Area> areaList;
    private List<Halltype> halltypeList;

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    public List<Halltype> getHalltypeList() {
        return halltypeList;
    }

    public void setHalltypeList(List<Halltype> halltypeList) {
        this.halltypeList = halltypeList;
    }
}
