package com.bugong.xiuadmin.common.query;

import com.google.common.base.CaseFormat;

public class Sort {

    private String field;
    private Boolean desc;

    public String getField() {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field);
    }

    public void setField(String field) {
        this.field = field;
    }

    public Boolean getDesc() {
        return desc;
    }

    public void setDesc(Boolean desc) {
        this.desc = desc;
    }
}
