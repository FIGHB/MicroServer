package com.stylefeng.guns.order.common.persistence.model;

public class LRMiddleTableBean {
    private Integer fieldId;
    private LRMtimeCinemaT cinema;
    private LRMtimeFieldT field;
    private LRMtimeFilmT film;
    private LRMtimeHallDictT hallDict;

    public LRMtimeHallDictT getHallDict() {
        return hallDict;
    }

    public void setHallDict(LRMtimeHallDictT hallDict) {
        this.hallDict = hallDict;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public LRMtimeCinemaT getCinema() {
        return cinema;
    }

    public void setCinema(LRMtimeCinemaT cinema) {
        this.cinema = cinema;
    }

    public LRMtimeFieldT getField() {
        return field;
    }

    public void setField(LRMtimeFieldT field) {
        this.field = field;
    }

    public LRMtimeFilmT getFilm() {
        return film;
    }

    public void setFilm(LRMtimeFilmT film) {
        this.film = film;
    }
}
