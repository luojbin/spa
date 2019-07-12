package com.loyofo.spa.webapp.common.exhandler;

import com.loyofo.spa.webapp.common.exception.AdviceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(AdviceException.class)
    @ResponseBody
    public String adviceExpHandler(Exception e){
        logger.error("MyExceptionHandler 拦截到异常: ", e);
        return "已拦截 AdviceException";
    }
}
