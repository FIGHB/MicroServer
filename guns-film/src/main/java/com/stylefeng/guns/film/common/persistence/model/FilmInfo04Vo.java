package com.stylefeng.guns.film.common.persistence.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FilmInfo04Vo implements Serializable {

    private static final long serialVersionUID = -3529542168819223804L;
    Object actors;
    String biopgraphy;
    String filmId;
    Map<String, Object> imgVO;

    public Object getActors() {
        return actors;
    }

    public void setActors(Object actors) {
        this.actors = actors;
    }

    public String getBiopgraphy() {
        return biopgraphy;
    }

    public void setBiopgraphy(String biopgraphy) {
        this.biopgraphy = biopgraphy;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public Map<String, Object> getImgVO() {
        return imgVO;
    }

    public void setImgVO(Map<String, Object> imgVO) {
        this.imgVO = imgVO;
    }
}
