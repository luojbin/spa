package com.loyofo.spa.java.controller;

import com.loyofo.spa.java.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/param")
public class ParamController {

    private static final Logger log = LoggerFactory.getLogger(ParamController.class);

    /**
     * 对于查询参数, 可以直接获取, 也可以通过 @RequestParam 标记
     * 如果前端提交的参数名, 与方法形参的名字不同, 可以用注解 @RequestParam 的 value 属性指定别名
     * 注解 @RequestParam 可以为查询参数赋予默认值, 当前端提交的请求没有提供指定参数时, spring 为参数提供默认值
     */
    @RequestMapping("query")
    @ResponseBody
    public String queryParam(
            @RequestParam(value = "id", defaultValue = "默认名字=道明寺") String name,
            @RequestParam(defaultValue = "20") int age,
            @RequestParam(defaultValue = "默认地址=深圳南山") String address
    ) {
        log.info("获取请求参数, name={}, age={}, address={}", name, age, address);
        return "ok";
    }

    /**
     * 如果控制器方法需要一个指定类型的对象, spring 会自动根据对象中的实例域, 去匹配前端提交的请求参数
     * 如果前端提交的参数名与该类实例域名称一致, spring 就会将该参数注入到对象的实例域中
     */
    @RequestMapping("person")
    @ResponseBody
    public String queryParam(Person person) {
        log.info("获取请求参数, person={}", person);
        return "ok";
    }
}
