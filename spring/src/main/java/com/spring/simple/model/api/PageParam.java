package com.spring.simple.model.api;

/**
 * 分页相关VO
 * Created by fengxu on 15-12-16.
 */
public class PageParam {
    private Integer page;
    private Integer pageSize;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
