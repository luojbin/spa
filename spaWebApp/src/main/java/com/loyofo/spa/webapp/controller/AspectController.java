package com.loyofo.spa.webapp.controller;

import com.loyofo.spa.webapp.service.AspectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/aspect")
public class AspectController {

    private static Logger logger = LoggerFactory.getLogger(AspectController.class);

    @Autowired
    private AspectService aspectService;

    @RequestMapping("/order/ok")
    @ResponseBody
    public String orderOk(){
        logger.info("████████ 测试切面顺序 ████████");
        return "测试成功, 看控制台";
    }

    @RequestMapping("/order/exp")
    @ResponseBody
    public String orderExp(){
        logger.info("████████ 被切方法抛出异常, 切面捕获异常 ████████");
        throw new RuntimeException("被切方法抛出异常");
    }

    @RequestMapping("/around/ok")
    @ResponseBody
    public String aroundOk(){
        logger.info("████████ 测试环绕通知 ████████");
        return "测试成功, 看控制台";
    }

    @RequestMapping("/around/exp")
    @ResponseBody
    public String aroundExp() {
        logger.info("████████ 被切方法抛出异常, 切面捕获异常 ████████");
        throw new RuntimeException("被切方法抛出异常");
    }

    @RequestMapping("/exp")
    @ResponseBody
    public String exp(){
        logger.info("████████ 切面抛出异常, 进不来了吧? ████████");
        return "你看不见我, 看到我就说明不对了";
    }
    @RequestMapping("/expAround")
    @ResponseBody
    public String expAround(){
        logger.info("████████ 切面抛出异常, 进不来了吧? ████████");
        return "你看不见我, 看到我就说明不对了";
    }

    @RequestMapping("args")
    @ResponseBody
    public String args() {
        aspectService.oneIntArg(1);
        aspectService.aArg(2);
        aspectService.twoArg(3, "ass");
        return "ok";
    }
}
