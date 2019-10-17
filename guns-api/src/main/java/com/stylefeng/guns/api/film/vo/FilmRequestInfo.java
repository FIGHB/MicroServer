package com.stylefeng.guns.api.film.vo;

import java.io.Serializable;

public class FilmRequestInfo implements Serializable {
    private static final long serialVersionUID = 2181408815052867481L;
    private Integer showType;// mtime_film_t  film_status 影片状态,1-正在热映，2-即将上映，3-经典影片
    //热门搜索 票房 mtime_film_t    film_box_office    int
    //时间搜索 上映时间 mtime_film_t    film_time
    //评价搜索 影片评分 mtime_film_t    film_score
    private Integer sortId;//mtime_film_t 排序方式，1-按热门搜索，2-按时间搜索，3-按评价搜索
    //类型编号 表格mtime_film_t中film_cats，多个分类以#分割； 具体见表 m_time_cat_dict_t
    private Integer catId;
    //区域编号,表格mtime_film_t中film_area,具体见表 m_time_source_dict_t
    private Integer sourceId;
    //年代编号,表格mtime_film_t中film_date,具体见表 m_time_year_dict_t
    private Integer yearId;
    //影片列表当前页，翻页使用
    private Integer nowPage;
    //每页显示条数
    private Integer pageSize;

    public FilmRequestInfo() {
    }

    @Override
    public String toString() {
        return "FilmRequestInfo{" +
                "showType=" + showType +
                ", sortId=" + sortId +
                ", catId=" + catId +
                ", sourceId=" + sourceId +
                ", yearId=" + yearId +
                ", nowPage=" + nowPage +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
