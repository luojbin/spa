package com.loyofo.spa.webapp.controller.extra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

import static com.loyofo.spa.webapp.common.constant.MvcContant.REDIRECT_PRIFIX;

@Controller
@RequestMapping("/flash")
public class FlashAttrController {

    private Logger log = LoggerFactory.getLogger(FlashAttrController.class);

    @RequestMapping("/sendMsgWithPath")
    public String sendMsgWithPath(@RequestParam("msg") String msg, @RequestParam("author") String author, Model model){
        log.info("准备发出重定向, 路径携带消息: {}, 作者: {}", msg, author);
        model.addAttribute("msg", msg);
        model.addAttribute("author", author);
        return REDIRECT_PRIFIX + "/flash/getMsgFromPath/{msg}";
    }

    @RequestMapping("/getMsgFromPath/{msg}")
    @ResponseBody
    public String getMsgFromPath(@PathVariable String msg, @RequestParam("author") String author){
        log.info("成功获取到重定向的消息: {}, 作者: {}", msg, author);
        return "成功获取到重定向的消息";
    }

    @RequestMapping("/sendMsgWithFlash")
    public String sendMsgWithFlash(@RequestParam("msg") String msg, @RequestParam("author") String author, RedirectAttributes model) {
        log.info("准备发出重定向, flash携带消息: {}, 作者: {}", msg, author);
        model.addFlashAttribute("msg", msg);
        model.addFlashAttribute("author", author);
        return REDIRECT_PRIFIX + "/flash/getMsgFromFlash";
    }


    @RequestMapping("/getMsgFromFlash")
    public String getMsgFromFlash(Model model){
        Map<String, Object> attrs = model.asMap();
        String msg = String.valueOf(attrs.get("msg"));
        String author = String.valueOf(attrs.get("author"));
        log.info("成功获取到 flash 属性, msg={}. author={}", msg, author);
        return "ok";
    }


}
