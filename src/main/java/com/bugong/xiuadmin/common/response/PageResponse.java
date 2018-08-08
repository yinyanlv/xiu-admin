package com.bugong.xiuadmin.common.response;

import java.util.Collection;

public class PageResponse {

    private Collection<?> list;
    private Integer total;

    public PageResponse(PageData pageData) {
       this.list = pageData.getList();
       this.total = pageData.getTotal();
    }

    public Collection<?> getList() {
        return list;
    }

    public void setList(Collection<?> list) {
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
