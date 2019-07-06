package com.loyofo.spa.java.controller;

import com.loyofo.spa.java.dao.SpitterRepository;
import com.loyofo.spa.java.entity.Spitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String showRegistrationForm() {
        return "form";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submitRegistrationForm(Spitter spitter) {
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

}
