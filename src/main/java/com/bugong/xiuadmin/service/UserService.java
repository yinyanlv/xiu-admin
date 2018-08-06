package com.bugong.xiuadmin.service;

import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.dao.UserDao;
import com.bugong.xiuadmin.entity.User;
import com.bugong.xiuadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao<User> userDao;

    public List<User> getUsers() {
        ReqArgs r = new ReqArgs();
        return userDao.queryAll(r);
    }

    public void save(User user) {

        userRepository.save(user);
    }
}
