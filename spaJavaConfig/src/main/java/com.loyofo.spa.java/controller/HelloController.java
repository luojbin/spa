package com.loyofo.spa.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("home")
    public String hello() {
        log.info("顺利进来 javahome controller");
        return "javahome";
    }
}
