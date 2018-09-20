package com.bugong.xiuadmin.dao;

import com.bugong.xiuadmin.dao.common.DefaultQueryDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CategoryDao<T> extends DefaultQueryDao {
}
