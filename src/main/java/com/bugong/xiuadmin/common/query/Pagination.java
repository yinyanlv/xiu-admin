package com.bugong.xiuadmin.common.query;

public class Pagination {

    private Integer page;
    private Integer size;
    private Integer beginIndex;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getBeginIndex() {
        return (page - 1) * size;
    }
}
