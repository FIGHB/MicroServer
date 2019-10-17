package com.stylefeng.guns.api.bean.steve;

import java.io.Serializable;

/**
 * @author Steve
 * @date 2019/10/16-20:04
 */
public class SteveOrder implements Serializable {
    Integer newPage;
    Integer pageSize;

    public Integer getNewPage() {
        return newPage;
    }

    public void setNewPage(Integer newPage) {
        this.newPage = newPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
