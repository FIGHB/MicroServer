package com.stylefeng.guns.film.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 影片主表
 * </p>
 *
 * @author LiRui
 * @since 2019-10-14
 */
@TableName("mtime_film_t")
public class LRMtimeFilmT implements Serializable {
    private static final long serialVersionUID = -8734640183053204612L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer filmId;
    /**
     * 影片名称
     */
    @TableField("film_name")
    private String filmName;
    /**
     * 片源类型: 0-2D,1-3D,2-3DIMAX,4-无
     */
    @TableField("film_type")
    private Integer filmType;
    /**
     * 影片主图地址
     */
    @TableField("img_address")
    private String imgAddress;
    /**
     * 影片评分
     */
    @TableField("film_score")
    private String filmScore;
    /**
     * 影片预售数量
     */
    @TableField("film_preSaleNum")
    private Integer expectNum;
    /**
     * 影片票房：每日更新，以万为单位
     */
    @TableField("film_box_office")
    private Integer boxNum;
    /**
     * 影片片源，参照片源字典表
     */
    @TableField("film_source")
    private Integer filmSource;
    /**
     * 影片分类，参照分类表,多个分类以#分割
     */
    @TableField("film_cats")
    private String filmCats;
    /**
     * 影片区域，参照区域表
     */
    @TableField("film_area")
    private Integer filmArea;
    /**
     * 影片上映年代，参照年代表
     */
    @TableField("film_date")
    private Integer filmDate;
    /**
     * 影片上映时间
     */
    @TableField("film_time")
    private Date filmTime;
    /**
     * 影片状态,1-正在热映，2-即将上映，3-经典影片
     */
    @TableField("film_status")
    private Integer filmStatus;

    private String filmLength;

    private Date showTime;

    private String score;

    public LRMtimeFilmT() {
        this.filmLength = "";
    }


    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getFilmType() {
        return filmType;
    }

    public void setFilmType(Integer filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }


    public Integer getFilmSource() {
        return filmSource;
    }

    public void setFilmSource(Integer filmSource) {
        this.filmSource = filmSource;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public Integer getFilmArea() {
        return filmArea;
    }

    public void setFilmArea(Integer filmArea) {
        this.filmArea = filmArea;
    }

    public Integer getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(Integer filmDate) {
        this.filmDate = filmDate;
    }

    public Date getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(Date filmTime) {
        this.filmTime = filmTime;
    }

    public Integer getFilmStatus() {
        return filmStatus;
    }

    public void setFilmStatus(Integer filmStatus) {
        this.filmStatus = filmStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(Integer expectNum) {
        this.expectNum = expectNum;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "LRMtimeFilmT{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", filmType=" + filmType +
                ", imgAddress='" + imgAddress + '\'' +
                ", filmScore='" + filmScore + '\'' +
                ", expectNum=" + expectNum +
                ", boxNum=" + boxNum +
                ", filmSource=" + filmSource +
                ", filmCats='" + filmCats + '\'' +
                ", filmArea=" + filmArea +
                ", filmDate=" + filmDate +
                ", filmTime=" + filmTime +
                ", filmStatus=" + filmStatus +
                ", filmLength='" + filmLength + '\'' +
                ", showTime=" + showTime +
                ", score=" + score +
                '}';
    }
}
