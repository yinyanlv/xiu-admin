package com.bugong.xiuadmin.controller;

import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.common.query.ReqArgsParser;
import com.bugong.xiuadmin.common.response.PageData;
import com.bugong.xiuadmin.common.response.PageResponse;
import com.bugong.xiuadmin.common.response.Response;
import com.bugong.xiuadmin.dto.ArticleDto;
import com.bugong.xiuadmin.entity.ArticleEntity;
import com.bugong.xiuadmin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/page")
    public PageResponse page(@RequestParam String args) {

        ReqArgs reqArgs = ReqArgsParser.parse(args);
        PageData data = articleService.queryPage(reqArgs);

        return new PageResponse(data);
    }

    @RequestMapping(value = "/create")
    public Response create(ArticleDto articleDto) {

        articleService.create(articleDto);

        return Response.success("文章新建成功");
    }

    @RequestMapping(value = "/update")
    public Response update(ArticleEntity articleEntity) {

        articleService.update(articleEntity);

        return Response.success("文章修改成功");
    }

    @RequestMapping(value = "/delete")
    public Response delete(@RequestBody List<String> idList) {

        articleService.delete(idList);

        return Response.success("文章删除成功");
    }
}
