package com.loyofo.spa.webapp.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    private String name;

    public MyInterceptor(){
        this.name = "默认拦截器";
    }

    public MyInterceptor(String name) {
        this.name = name;
    }

    Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("拦截器 {} 在请求 {} 之前进行拦截 ",getName(), request.getServletPath());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("拦截器 {} 在请求 {} 之后进行拦截 ", getName(), request.getServletPath());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("拦截器 {} 在请求 {} 结束之前进行拦截 ", getName(), request.getServletPath());
    }

    public String getName() {
        return name;
    }
}
