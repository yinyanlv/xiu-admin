package com.bugong.xiuadmin.controller;

import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.common.query.ReqArgsParser;
import com.bugong.xiuadmin.common.response.PageData;
import com.bugong.xiuadmin.common.response.PageResponse;
import com.bugong.xiuadmin.common.response.Response;
import com.bugong.xiuadmin.dto.CategoryDto;
import com.bugong.xiuadmin.entity.CategoryEntity;
import com.bugong.xiuadmin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public PageResponse page(@RequestParam String args) {

        ReqArgs reqArgs = ReqArgsParser.parse(args);
        PageData data = categoryService.queryPage(reqArgs);

        return new PageResponse(data);
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public Response create(CategoryDto categoryDto) {

        categoryService.create(categoryDto);

        return Response.success("分类新建成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Response update(CategoryEntity categoryEntity) {

        categoryService.update(categoryEntity);

        return Response.success("分类修改成功");
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Response delete(@RequestBody List<String> idList) {

        categoryService.delete(idList);
        return Response.success("分类删除成功");
    }
}
