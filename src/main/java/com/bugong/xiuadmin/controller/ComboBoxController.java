package com.bugong.xiuadmin.controller;

import com.bugong.xiuadmin.common.response.Response;
import com.bugong.xiuadmin.dao.ComboBoxDao;
import com.bugong.xiuadmin.dto.ComboBoxDto;
import com.google.common.base.CaseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/combo-box")
public class ComboBoxController {

    @Autowired
    private ComboBoxDao comboBoxDao;

    @RequestMapping(value = "/{moduleName}/list")
    public Response list(@PathVariable String moduleName) {

        String tableName = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_UNDERSCORE, moduleName);
        List<ComboBoxDto> list = comboBoxDao.list(tableName);

        return Response.success(list);
    }
}
