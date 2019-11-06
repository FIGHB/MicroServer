package com.stylefeng.guns.order.common.persistence.model;

import java.util.List;
import java.util.Map;

public class LRSeatBean {
    Integer limit;
    String ids;
    List<List<Map<String, Integer>>> single;
    List<List<Map<String, Integer>>> couple;

    @Override
    public String toString() {
        return "LRSeatBean{" +
                "limit=" + limit +
                ", ids='" + ids + '\'' +
                ", single=" + single +
                ", couple=" + couple +
                '}';
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public List<List<Map<String, Integer>>> getSingle() {
        return single;
    }

    public void setSingle(List<List<Map<String, Integer>>> single) {
        this.single = single;
    }

    public List<List<Map<String, Integer>>> getCouple() {
        return couple;
    }

    public void setCouple(List<List<Map<String, Integer>>> couple) {
        this.couple = couple;
    }
}
