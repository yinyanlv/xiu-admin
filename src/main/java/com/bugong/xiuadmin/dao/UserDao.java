package com.bugong.xiuadmin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao<T> {

    List<T> queryAll();
}
