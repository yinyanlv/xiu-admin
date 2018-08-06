package com.bugong.xiuadmin.service;

import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.dao.UserDao;
import com.bugong.xiuadmin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao<User> userDao;

    public List<User> getUsers() {
        ReqArgs r = new ReqArgs();
        return userDao.queryAll(r);
    }
}
