package com.loyofo.spa.webapp.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {

    private String name;

    public MyFilter(){
        this.name = "默认过滤器";
    }

    public MyFilter(String name){
        this.name = name;
    }

    Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String initParam = filterConfig.getInitParameter("name");
        if ("默认过滤器".equals(getName()) && initParam != null) {
            this.name = initParam;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        logger.info("过滤器 {} 拦截了请求 {}", getName(), req.getServletPath());
        chain.doFilter(request, response);
        logger.info("过滤器 {} 在请求返回前又记录了一次日志: {}", getName(), req.getServletPath());
    }

    @Override
    public void destroy() {

    }

    public String getName() {
        return name;
    }
}
