package com.loyofo.spa.java.controller.extra;

import com.loyofo.spa.java.dao.SpittleRepository;
import com.loyofo.spa.java.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * model and view 不同情况的附加测试
 */
@RequestMapping("/mav")
public class MavController {
    private SpittleRepository spittleRepository;

    @Autowired
    public MavController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /**
     * 获取 Model 为参数, 可以通过这个 model 将数据传递给视图, 方法返回视图名
     * 不指定数据对象的名字, 则根据类型推断, 此处推断为 stringList
     */
    @RequestMapping("msgAndModel")
    public String getMsgAndModel(Model model) {
        List<Spittle> list = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        model.addAttribute(list);
        return "msg";
    }

    /**
     * 获取 Model 为参数, 可以通过这个 model 将数据传递给视图, 方法返回视图名
     */
    @RequestMapping("msgAndModelWithName")
    public String getMsgAndModelWithName(Model model) {
        List<Spittle> list = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        model.addAttribute("modelWithName", list);
        return "msg";
    }

    /**
     * 获取 Map 作为参数, 也可以将数据传递给视图, 方法返回视图名
     */
    @RequestMapping("msgAndMap")
    public String getMsgAndMap(Map<String, Object> map) {
        List<Spittle> list = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        map.put("msgAndMap", list);
        return "msg";
    }

    /**
     * 直接返回对象, 则这个对象会被放到 request 中传递给视图, key 根据对象的类型推断, 此处推断key 为 stringList
     * 不指定视图名, 则视图名等于请求名
     */
    @RequestMapping("msg")
    public List<Spittle> getMsg() {
        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
    }

}
