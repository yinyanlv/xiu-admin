package com.bugong.xiuadmin.dao;

import com.bugong.xiuadmin.dao.common.DefaultQueryDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ComboBoxDao<T> extends DefaultQueryDao {
    List<T> list(@Param("tableName") String tableName);
}
