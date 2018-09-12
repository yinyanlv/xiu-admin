package com.bugong.xiuadmin.service;

import com.bugong.xiuadmin.common.context.UserContext;
import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.common.response.PageData;
import com.bugong.xiuadmin.common.util.Generate;
import com.bugong.xiuadmin.dao.UserDao;
import com.bugong.xiuadmin.dto.UserCreateDto;
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

    public PageData queryPage(ReqArgs reqArgs) {
        int total = userDao.count(reqArgs);
        List<UserDto> list =  userDao.queryPage(reqArgs);
        return new PageData(list, total);
    }

    public void create(UserCreateDto userCreateDto) {

        Date now = Generate.getNow();
        String username = UserContext.getUsername();
        User user = new User();

        user.setId(Generate.getUUID());
        user.setUsername(userCreateDto.getUsername());
        user.setNickname(userCreateDto.getNickname());
        user.setEmail(userCreateDto.getEmail());
        user.setPhone(userCreateDto.getPhone());
        user.setQq(userCreateDto.getQq());
        user.setRole(userCreateDto.getRole());
        user.setStatus(userCreateDto.getStatus());
        user.setPassword(userCreateDto.getPassword());
        user.setCreateBy(username);
        user.setCreateTime(now);
        user.setUpdateBy(username);
        user.setUpdateTime(now);

        userRepository.save(user);
    }

    public User getUserById(String id) {

        return userRepository.getOne(id);
    }

    @Transactional
    public void update(User user) {

        userRepository.getOne(user.getId()).update(user);
    }

    @Transactional
    public void updatePassword(String id, String password) {

        userRepository.getOne(id).updatePassword(password);
    }

    @Transactional
    public void delete(List<String> idList) {

        idList.forEach(id -> {
            userRepository.deleteById(id);
        });
    }
}
