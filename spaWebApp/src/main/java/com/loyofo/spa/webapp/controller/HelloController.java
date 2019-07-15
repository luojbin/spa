package com.loyofo.spa.webapp.controller;

import com.loyofo.spa.webapp.entity.Clazz;
import com.loyofo.spa.webapp.entity.Student;
import com.loyofo.spa.webapp.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/hello")
@Controller
public class HelloController {

    {
        logger.info("HelloController 已创建:{}",  this);
    }

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("clazz/{id}")
    @ResponseBody
    public Clazz getClazz(@PathVariable("id") String clazzId) {
        logger.info("尝试获取 clazz");
        Clazz clazz = service.getClazz(clazzId);
        logger.info("成功获取 clazz: {}", clazz);
        return clazz;
    }

    @Resource
    private HelloService service;

    @RequestMapping("world")
    @ResponseBody
    public String helloWorld(){
        service.getStudentById("11");
        return "hello world";
    }

    @RequestMapping("assert")
    @ResponseBody
    public String assertTrue(){
        return "你看不见我";
    }

    @RequestMapping("trace")
    @ResponseBody
    public String getTrace() throws InterruptedException {
        return service.getAllStackTrace();
    }

    @RequestMapping("all")
    @ResponseBody
    public List<Clazz> all(){
        List<Clazz> all = service.getAll();
        all.forEach(c -> System.out.println(c));
        return all;
    }

    @RequestMapping("allClazz")
    @ResponseBody
    public List<Clazz> allClazz() {
        List<Clazz> all = service.getAllClazz();
        all.forEach(c -> System.out.println(c));
        return all;
    }

    @RequestMapping("student")
    @ResponseBody
    public String student(Student student) {
        System.out.println(student);
        System.out.println("中文测试");
        return "测试通过";
    }
    @RequestMapping("chn")
    @ResponseBody
    public String chn(String msg) {
        System.out.println(msg);
        System.out.println("中文测试");
        return "测试通过";
    }



}
