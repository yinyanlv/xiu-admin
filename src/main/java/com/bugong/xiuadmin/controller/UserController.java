package com.bugong.xiuadmin.controller;

import java.util.List;

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
    public List<User> getUsers() {

        return userService.getUsers();
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public String create(@RequestBody User user) {
        userService.save(user);
        return "success";
    }
}
