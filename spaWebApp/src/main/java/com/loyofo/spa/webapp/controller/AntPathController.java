package com.loyofo.spa.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ant")
public class AntPathController {

    private static Logger logger = LoggerFactory.getLogger(AntPathController.class);

    @RequestMapping("/a")
    @ResponseBody
    public String a(){
        logger.info("████████ 测试 antPath ████████: /antPath/a");
        return "ok";
    }

    @RequestMapping("/b/c")
    @ResponseBody
    public String bc(){
        logger.info("████████ 测试 antPath ████████: /antPath/b/c");
        return "ok";
    }

    @RequestMapping("/d/e/f")
    @ResponseBody
    public String def(){
        logger.info("████████ 测试 antPath ████████: /antPath/d/e/f");
        return "ok";
    }

}
