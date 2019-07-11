package com.loyofo.spa.webapp.controller.extra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterceptorController {

    private Logger log = LoggerFactory.getLogger(InterceptorController.class);

    @RequestMapping("/inter1/{id}")
    @ResponseBody
    public String inter1(@PathVariable String id) {
        log.info("inter1 获取路径参数, id={}", id);
        return "ok";
    }
    @RequestMapping("/inter2/{id}")
    @ResponseBody
    public String inter2(@PathVariable String id) {
        log.info("inter2 获取路径参数, id={}", id);
        return "ok";
    }
}
