package com.bugong.xiuadmin.service;

import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.common.util.Generate;
import com.bugong.xiuadmin.dao.UserDao;
import com.bugong.xiuadmin.dto.UserDto;
import com.bugong.xiuadmin.entity.User;
import com.bugong.xiuadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao<UserDto> userDao;

    public List<UserDto> queryPage(ReqArgs reqArgs) {

        return userDao.queryPage(reqArgs);
    }

    public void create(User user) {

        Date now = Generate.getNow();

        user.setCreateBy("admin");
        user.setCreateTime(now);
        user.setUpdateBy("admin");
        user.setUpdateTime(now);

        userRepository.save(user);
    }

    @Transactional
    public void update(User user) {

        userRepository.getOne(user.getId()).update(user);
    }

    @Transactional
    public void delete(List<Long> idList) {

        idList.forEach(id -> {
            userRepository.deleteById(id);
        });
    }
}
