package com.loyofo.spa.java.controller.extra;

import com.loyofo.spa.java.entity.Spittle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/param")
public class ParamController {

    private static final Logger log = LoggerFactory.getLogger(ParamController.class);
    /**
     * 对于查询参数, 可以直接获取, 也可以通过 @RequestParam 标记
     * 如果前端提交的参数名, 与方法形参的名字不同, 可以用注解 @RequestParam 的 value 属性指定别名
     * 注解 @RequestParam 可以为查询参数赋予默认值, 当前端提交的请求没有提供指定参数时, spring 为参数提供默认值
     */
    @RequestMapping("/query")
    @ResponseBody
    public String queryParam(
            @RequestParam(name = "id", defaultValue = "默认名字=道明寺") String name,
            @RequestParam(defaultValue = "20") int age,
            @RequestParam(defaultValue = "默认地址=深圳南山") String address
    ) {
        log.info("获取请求参数, name={}, age={}, address={}", name, age, address);
        return "query ok";

    }

    /**
     * 如果控制器方法需要一个指定类型的对象, spring 会自动根据对象中的实例域, 去匹配前端提交的请求参数
     * 如果前端提交的参数名与该类实例域名称一致, spring 就会将该参数注入到对象的实例域中
     */
    @RequestMapping("/person")
    @ResponseBody
    public String queryPerson(Spittle spittle) {
        log.info("获取请求参数, spittle={}", spittle);
        return "spittle ok";
    }

    /**
     * 如果路径参数占位符名字, 与方法形参相同, 可以省略注解中的 value/name 属性
     */
    @RequestMapping("/path/id/{id}")
    @ResponseBody
    public String queryPathVariable(@PathVariable String id) {
        log.info("@PathVariable 获取路径参数, id={}", id);
        return "ok";
    }

    /**
     * 如果路径参数占位符名字, 与方法形参不同, 则必须在注解的 value/name 属性中指定
     */
    @RequestMapping("/path/name/{name}")
    @ResponseBody
    public String queryPathVariable2(@PathVariable("name") String id) {
        log.info("@PathVariable(\"name\")获取路径参数, id={}", id);
        return "ok";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String getForm() {
        log.info("获取表单");
        return "form";
    }

    /**
     * 若表单没有通过 action 指定提交地址, 默认提交给显示表单的地址
     * 即通过同一请求路径, get 方法获取表单, post 方法提交表单
     */
    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String submitForm(Spittle spittle) {
        log.info("表单提交参数: spittle={}", spittle);
        // 若返回的视图名前缀为 redirect: , 则会给浏览器返回一个重定向响应, 让浏览器请求指定地址
        return "redirect:/home/viewname";
    }

}
