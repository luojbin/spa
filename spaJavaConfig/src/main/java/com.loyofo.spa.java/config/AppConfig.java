package com.loyofo.spa.java.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * webapp 初始化类, 取代 web.xml
 */
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 相当于在 web.xml 中指定 contextConfigLocation 为 config-context.xml
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 相当于在 web.xml 中为 dispatcherSerlvet 指定 contextConfigLocation 为 config-web.xml
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 相当于在 web.xml 中为 dispatcherServlet 指定 mapping 为 /
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
