package com.bugong.xiuadmin.common.query;

import java.util.ArrayList;
import java.util.List;

public class ReqArgs {

    private List<Filter> filters = new ArrayList<Filter>();
    private List<Sort> sorts;
    private Pagination pagination;

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public List<Sort> getSorts() {
        return sorts;
    }

    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
