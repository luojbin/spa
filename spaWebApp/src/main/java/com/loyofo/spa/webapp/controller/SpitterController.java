package com.loyofo.spa.webapp.controller;

import com.loyofo.spa.webapp.dao.SpitterRepository;
import com.loyofo.spa.webapp.entity.Spitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private static Logger log = LoggerFactory.getLogger(SpitterController.class);

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("spitter", new Spitter());
        return "form";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submitRegistrationForm(@Valid Spitter spitter, Errors error) {
        if (error.hasErrors()) {
            log.warn("error 校验失败, {}", error);
            log.warn("spitter 参数有误");
            return "form";
        }
            log.info("spitter 参数无误");
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    public String newString(){ return null; }
    public String saveString(){ return null; }

    public String getString(){ return null; }

    public String myString(){ return null; }
    public String checkString(){ return null; }


    public Spitter save(Spitter spitter) {
        return spitterRepository.save(spitter);
    }

    public static void staticMethod() {

    }
}
