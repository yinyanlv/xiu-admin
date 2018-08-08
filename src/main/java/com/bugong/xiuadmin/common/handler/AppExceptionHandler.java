package com.bugong.xiuadmin.common.handler;

import com.bugong.xiuadmin.common.response.ExceptionResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionResponse handleException(Exception e, HttpServletResponse httpServletResponse) {

        e.printStackTrace();

        httpServletResponse.setStatus(599);

        return new ExceptionResponse(e.getMessage());
    }
}
