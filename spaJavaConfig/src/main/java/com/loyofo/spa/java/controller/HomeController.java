package com.loyofo.spa.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 声明控制器
@Controller
// 在类上添加路径映射, 可以用 String 数组指定多个
@RequestMapping({"/", "/homepage"})
public class HomeController {
    private static Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        log.info("顺利进来 homepage controller");
        return "home";
    }


}
