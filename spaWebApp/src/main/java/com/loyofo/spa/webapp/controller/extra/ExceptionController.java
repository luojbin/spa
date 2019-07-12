package com.loyofo.spa.webapp.controller.extra;

import com.loyofo.spa.webapp.common.exception.AdviceException;
import com.loyofo.spa.webapp.common.exception.ControllerException;
import com.loyofo.spa.webapp.common.exception.MyStatusCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exp")
public class ExceptionController {

    private Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @RequestMapping("/code")
    @ResponseBody
    public String getStatusCode(){
        throw new MyStatusCodeException();
    }

    @RequestMapping("/advice")
    @ResponseBody
    public String getAdviceExp() {
        throw new AdviceException();
    }

    @RequestMapping("/ctrl")
    @ResponseBody
    public String getCtrlExp() {
        throw new ControllerException();
    }

    @ExceptionHandler(ControllerException.class)
    @ResponseBody
    public String ctrlExpHandler(Exception e) {
        logger.error("ExceptionController 拦截到异常: ", e);
        return "已拦截 ControllerException";
    }

}
