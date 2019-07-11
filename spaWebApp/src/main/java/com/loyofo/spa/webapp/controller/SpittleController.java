package com.loyofo.spa.webapp.controller;

import com.loyofo.spa.webapp.dao.SpittleRepository;
import com.loyofo.spa.webapp.entity.Spittle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpittleController {
    private static Logger log = LoggerFactory.getLogger(SpittleController.class);

    public static final String MAX_LONG_AS_STRING = "" + Long.MAX_VALUE;

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value="/recentSpittles",method = RequestMethod.GET)
    public String getRecentSpittle(Model model) {
        log.info("顺利进来 recentSpittles controller");
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    @RequestMapping(value="/spittles",method = RequestMethod.GET)
    public List<Spittle> getSpittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count
    ) {
        log.info("getSpittles 成功获取参数, max={}, count={}", max, count);
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping("/spittle/{id}")
    public String showSpittle(
            @PathVariable("id") long spittleId, Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }



}
