package com.bugong.xiuadmin.dao;

import java.util.List;

import com.bugong.xiuadmin.dao.common.DefaultQueryDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao<T> extends DefaultQueryDao {
}
