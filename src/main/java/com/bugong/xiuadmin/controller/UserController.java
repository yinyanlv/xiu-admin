package com.bugong.xiuadmin.controller;

import java.util.List;

import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.common.query.ReqArgsParser;
import com.bugong.xiuadmin.common.response.PageData;
import com.bugong.xiuadmin.common.response.PageResponse;
import com.bugong.xiuadmin.common.response.Response;
import com.bugong.xiuadmin.dto.UserCreateDto;
import com.bugong.xiuadmin.dto.UserModifyPasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bugong.xiuadmin.entity.UserEntity;
import com.bugong.xiuadmin.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/page")
    @ResponseBody
    public PageResponse page(@RequestParam String args) {

        ReqArgs reqArgs = ReqArgsParser.parse(args);
        PageData data = userService.queryPage(reqArgs);

        return new PageResponse(data);
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public Response create(@RequestBody UserCreateDto userCreateDto) {

        if (!userCreateDto.getPassword().equals(userCreateDto.getConfirmPassword())) {
            return Response.failed("两次输入的密码不一致");
        }

        userCreateDto.setPassword(bCryptPasswordEncoder.encode(userCreateDto.getPassword()));
        userService.create(userCreateDto);

        return Response.success("用户新建成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Response update(@RequestBody UserEntity userEntity) {

        userService.update(userEntity);
        return Response.success("用户修改成功");
    }

    @RequestMapping(value = "/modify-password")
    @ResponseBody
    public Response modifyPassword(@RequestBody UserModifyPasswordDto userModifyPasswordDto) {

        String id = userModifyPasswordDto.getId();
        UserEntity userEntity = userService.getUserById(id);

        if (userEntity.getId() == null) {
            return Response.failed("该用户不存在");
        }

        String oldPassword = bCryptPasswordEncoder.encode(userModifyPasswordDto.getOldPassword());

        if (!oldPassword.equals(userEntity.getPassword())) {
            return Response.failed("原密码不正确");
        }

        String password = userModifyPasswordDto.getPassword();
        String confirmPassword = userModifyPasswordDto.getPassword();

        if (password != confirmPassword) {
            return Response.failed("两次输入的新密码不一致");
        }

        userService.updatePassword(id, bCryptPasswordEncoder.encode(password));

        return Response.success("密码更改成功");
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Response delete(@RequestBody List<String> idList) {

        userService.delete(idList);
        return Response.success("用户删除成功");
    }
}
