package com.bugong.xiuadmin.service;

import com.bugong.xiuadmin.common.context.UserContext;
import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.common.response.PageData;
import com.bugong.xiuadmin.common.util.Generate;
import com.bugong.xiuadmin.dao.UserDao;
import com.bugong.xiuadmin.dto.UserCreateDto;
import com.bugong.xiuadmin.dto.UserDto;
import com.bugong.xiuadmin.entity.UserEntity;
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
        UserEntity userEntity = new UserEntity();

        userEntity.setId(Generate.getUUID());
        userEntity.setUsername(userCreateDto.getUsername());
        userEntity.setNickname(userCreateDto.getNickname());
        userEntity.setEmail(userCreateDto.getEmail());
        userEntity.setPhone(userCreateDto.getPhone());
        userEntity.setQq(userCreateDto.getQq());
        userEntity.setRole(userCreateDto.getRole());
        userEntity.setStatus(userCreateDto.getStatus());
        userEntity.setPassword(userCreateDto.getPassword());
        userEntity.setCreateBy(username);
        userEntity.setCreateTime(now);
        userEntity.setUpdateBy(username);
        userEntity.setUpdateTime(now);

        userRepository.save(userEntity);
    }

    public UserEntity getUserById(String id) {

        return userRepository.getOne(id);
    }

    @Transactional
    public void update(UserEntity userEntity) {

        userRepository.getOne(userEntity.getId()).update(userEntity);
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
