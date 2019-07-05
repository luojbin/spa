package com.loyofo.spa.java.controller;

import com.loyofo.spa.java.dao.MsgRepository;
import com.loyofo.spa.java.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/home", "/"})
public class HomeController {
    private static Logger log = LoggerFactory.getLogger(HomeController.class);

    {
        log.warn("HomeController bean 已创建");
    }

    private MsgRepository msgRepository;

    @Autowired
    public HomeController(MsgRepository msgRepository) {
        this.msgRepository = msgRepository;
    }

    @RequestMapping("viewname")
    public String home() {
        log.info("顺利进来 javahome controller");
        return "javahome";
    }

    /**
     * 获取 Model 为参数, 可以通过这个 model 将数据传递给视图, 方法返回视图名
     * 不指定数据对象的名字, 则根据类型推断, 此处推断为 stringList
     */
    @RequestMapping("msgAndModel")
    public String getMsgAndModel(Model model){
        List<String> list = msgRepository.getMessage(Long.MAX_VALUE, 20);
        model.addAttribute(list);
        return "msg";
    }
    /**
     * 获取 Model 为参数, 可以通过这个 model 将数据传递给视图, 方法返回视图名
     */
    @RequestMapping("msgAndModelWithName")
    public String getMsgAndModelWithName(Model model){
        List<String> list = msgRepository.getMessage(Long.MAX_VALUE, 20);
        model.addAttribute("modelWithName", list);
        return "msg";
    }

    /**
     * 获取 Map 作为参数, 也可以将数据传递给视图, 方法返回视图名
     */
    @RequestMapping("msgAndMap")
    public String getMsgAndMap(Map<String, Object> map){
        List<String> list = msgRepository.getMessage(Long.MAX_VALUE, 20);
        map.put("msgAndMap", list);
        return "msg";
    }

    /**
     * 直接返回对象, 则这个对象会被放到 request 中传递给视图, key 根据对象的类型推断, 此处推断key 为 stringList
     * 不指定视图名, 则视图名等于请求名
     */
    @RequestMapping("msg")
    public List<String> getMsg(){
        return msgRepository.getMessage(Long.MAX_VALUE, 20);
    }



}
