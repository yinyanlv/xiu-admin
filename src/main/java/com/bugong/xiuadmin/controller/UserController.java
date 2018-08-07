package com.bugong.xiuadmin.controller;

import java.util.List;

import com.bugong.xiuadmin.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bugong.xiuadmin.entity.User;
import com.bugong.xiuadmin.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public List<UserDto> page() {

        return userService.queryPage();
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public String create(@RequestBody User user) {

        userService.create(user);
        return "success";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(@RequestBody User user) {

        userService.update(user);
        return "success";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestBody List<Long> idList) {

        userService.delete(idList);
        return "success";
    }
}
