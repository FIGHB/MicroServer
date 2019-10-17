package com.stylefeng.guns.film.common.persistence.model;

import java.io.Serializable;

public class SourceVO implements Serializable {
    private Integer sourceId;
    private String sourceName;
    private boolean active;

    @Override
    public String toString() {
        return "SourceVO{" +
                "sourceId=" + sourceId +
                ", sourceName='" + sourceName + '\'' +
                ", active=" + active +
                '}';
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
