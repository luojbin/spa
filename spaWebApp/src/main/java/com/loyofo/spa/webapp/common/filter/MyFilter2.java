package com.loyofo.spa.webapp.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter2 implements Filter {

    Logger logger = LoggerFactory.getLogger(MyFilter2.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        logger.info("MyFilter222 拦截了请求 {}",req.getServletPath());
        chain.doFilter(request, response);
        logger.info("MyFilter222 在请求返回前又记录了一次日志: {}", req.getServletPath());
    }

    @Override
    public void destroy() {

    }
}
