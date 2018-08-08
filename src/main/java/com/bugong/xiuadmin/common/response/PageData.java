package com.bugong.xiuadmin.common.response;

import java.util.Collection;

public class PageData {

    private Collection<?> list;
    private Integer total;

    public PageData(Collection<?> list, int total) {
        this.list = list;
        this.total = total;
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
