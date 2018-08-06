package com.bugong.xiuadmin.dao.common;

import java.util.List;

import com.bugong.xiuadmin.common.query.ReqArgs;

public interface DefaultQueryDao<T> {
    int count(ReqArgs reqArgs);

    List<T> queryPage(ReqArgs reqArgs);

    List<T> queryAll(ReqArgs reqArgs);

    T detail(Object params);
}
