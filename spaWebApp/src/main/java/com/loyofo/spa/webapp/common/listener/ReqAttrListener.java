package com.loyofo.spa.webapp.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpServletRequest;

public class ReqAttrListener implements ServletRequestAttributeListener {

    private Logger logger = LoggerFactory.getLogger(ReqAttrListener.class);

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        HttpServletRequest req = (HttpServletRequest) srae.getServletRequest();
        logger.info("监听器1 监听到 {} 请求添加属性, {}={}", req.getServletPath(), srae.getName(), srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        HttpServletRequest req = (HttpServletRequest) srae.getServletRequest();
        logger.info("监听器1 监听到 {} 请求移除属性, {}={}", req.getServletPath(), srae.getName(), srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        HttpServletRequest req = (HttpServletRequest) srae.getServletRequest();
        logger.info("监听器1 监听到 {} 请求替换属性, {}={}", req.getServletPath(), srae.getName(), srae.getValue());
    }
}
