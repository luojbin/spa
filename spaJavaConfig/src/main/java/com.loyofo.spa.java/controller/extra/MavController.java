package com.loyofo.spa.java.controller.extra;

import com.loyofo.spa.java.dao.SpittleRepository;
import com.loyofo.spa.java.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * model and view 不同情况的附加测试, 有以下几种类型, 都能完成
 *
 * 1. model 入参, 返回视图名
 * 2. model 入参, 不返回视图名, 则视图名等于请求名
 * 3. map 入参, 返回视图名
 * 4. map 入参, 不返回视图名, 则视图名等于请求名
 * 5. 无入参, 直接返回数据, 则视图名等于请求名
 * 6. 无入参, 返回 ModelAndView
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
    @RequestMapping("modelAndView")
    public String modelAndView(Model model) {
        List<Spittle> list = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        model.addAttribute(list);
        return "msg";
    }

    /**
     * 获取 Model 为参数, 可以通过这个 model 将数据传递给视图, 方法返回视图名
     */
    @RequestMapping("modelNoView")
    public Model modelNoView(Model model) {
        List<Spittle> list = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        model.addAttribute("modelWithName", list);
        return model;
    }

    /**
     * 获取 Map 作为参数, 也可以将数据传递给视图, 方法返回视图名
     */
    @RequestMapping("mapAndView")
    public String mapAndView(Map<String, Object> map) {
        List<Spittle> list = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        map.put("mapAndView", list);
        return "msg";
    }
    /**
     * 获取 Map 作为参数, 也可以将数据传递给视图, 方法返回视图名
     */
    @RequestMapping("mapNoView")
    public Map<String, Object> mapNoView(Map<String, Object> map) {
        List<Spittle> list = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        map.put("mapNoView", list);
        return map;
    }

    /**
     * 直接返回对象, 则这个对象会被放到 request 中传递给视图, key 根据对象的类型推断, 此处推断key 为 stringList
     * 不指定视图名, 则视图名等于请求名
     */
    @RequestMapping("dataNoView")
    public List<Spittle> data() {
        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
    }

    @RequestMapping("mavObject")
    public ModelAndView mavObject() {
        Map<String, Object> data = new HashMap<>();
        data.put("mavData", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return new ModelAndView("mavView", data);
    }



}
