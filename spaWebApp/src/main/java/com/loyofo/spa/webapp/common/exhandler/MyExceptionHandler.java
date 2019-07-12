package com.loyofo.spa.webapp.common.exhandler;

import com.loyofo.spa.webapp.common.exception.AdviceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(AdviceException.class)
    @ResponseBody
    public Map<String, String> adviceExpHandler(Exception e){
        logger.error("MyExceptionHandler 拦截到异常: ", e);
        Map<String, String> map = new HashMap<>();
        map.put("code", "500");
        map.put("msg", "caught adviceException ok");
        return map;
    }
}
