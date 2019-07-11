package com.loyofo.spa.webapp.controller.extra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FilterController {

    private Logger log = LoggerFactory.getLogger(FilterController.class);

    @RequestMapping("/filter3/{id}")
    @ResponseBody
    public String filter3GetId(@PathVariable String id, HttpServletRequest req) {
        log.info("filter3GetId 获取路径参数, id={}", id);
        String key = "filter3_atter";
        req.setAttribute(key, "filter3GetId 添加到 model 的消息");
        req.setAttribute(key, "filter3GetId 添加到 request 的消息");
        req.removeAttribute(key);
        return "ok";
    }
    @RequestMapping("/filter4/{id}")
    @ResponseBody
    public String filter4GetId(@PathVariable String id, HttpServletRequest req) {
        log.info("filter4GetId 获取路径参数, id={}", id);
        String key = "filter4_atter";
        req.setAttribute(key, "filter4GetId 添加到 model 的消息");
        req.setAttribute(key, "filter4GetId 添加到 request 的消息");
        req.removeAttribute(key);
        return "ok";
    }
}
