package com.iqianjin.sobotservice.config;

import com.iqianjin.sobotservice.entity.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler{

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Response execException(Exception e){
        e.printStackTrace();
        log.error(e.getMessage());
        return Response.fail("系统异常");
    }

}
