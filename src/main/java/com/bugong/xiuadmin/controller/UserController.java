package com.bugong.xiuadmin.controller;

import java.util.List;

import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.common.query.ReqArgsParser;
import com.bugong.xiuadmin.common.response.PageData;
import com.bugong.xiuadmin.common.response.PageResponse;
import com.bugong.xiuadmin.common.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bugong.xiuadmin.entity.User;
import com.bugong.xiuadmin.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public PageResponse page(@RequestParam String args) {

        ReqArgs reqArgs = ReqArgsParser.parse(args);
        PageData data = userService.queryPage(reqArgs);

        return new PageResponse(data);
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public Response create(@RequestBody User user) {

        userService.create(user);
        return Response.success("用户新建成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Response update(@RequestBody User user) {

        userService.update(user);
        return Response.success("用户修改成功");
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Response delete(@RequestBody List<Long> idList) {

        userService.delete(idList);
        return Response.success("用户删除成功");
    }
}
