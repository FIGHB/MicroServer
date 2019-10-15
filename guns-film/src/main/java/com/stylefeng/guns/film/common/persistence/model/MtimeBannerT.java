package com.stylefeng.guns.film.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * banner信息表
 * </p>
 *
 * @author LiRui
 * @since 2019-10-14
 */
@TableName("mtime_banner_t")
public class MtimeBannerT extends Model<MtimeBannerT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer bannerId;
    /**
     * banner图存放路径
     */
    @TableField("banner_address")
    private String bannerAddress;
    /**
     * banner点击跳转url
     */
    @TableField("banner_url")
    private String bannerUrl;
    /**
     * 是否弃用 0-失效,1-失效
     */
    @TableField("is_valid")
    private Integer isValid;


    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerAddress() {
        return bannerAddress;
    }

    public void setBannerAddress(String bannerAddress) {
        this.bannerAddress = bannerAddress;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    @Override
    protected Serializable pkVal() {
        return this.bannerId;
    }

    @Override
    public String toString() {
        return "MtimeBannerT{" +
                "bannerId=" + bannerId +
                ", bannerAddress='" + bannerAddress + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}
