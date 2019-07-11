package com.loyofo.spa.webapp.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class ReqListener implements ServletRequestListener {

    private Logger logger = LoggerFactory.getLogger(ReqListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        logger.info("监听器1 监听到 {} 请求被销毁", req.getServletPath());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        logger.info("监听器1 监听到 {} 请求被创建", req.getServletPath());
    }
}
