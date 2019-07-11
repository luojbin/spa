package com.loyofo.spa.java.config;

import com.loyofo.spa.webapp.common.filter.MyFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * webapp 初始化类, 取代 web.xml
 */
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定应用上下文的配置文件路径, 相当于在 web.xml 中配置
     *
     *<context-param>
     * 		<param-name>contextConfigLocation</param-name>
     * 		<param-value>classpath:config-context.xml</param-value>
     * 	</context-param>
     * 	<listener>
     * 		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
     * 	</listener>
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 指定 DispatcherServlet 上下文的配置文件路径, 相当于在 web.xml 中配置
     *
     * <servlet>
     * 		<servlet-name>dispatcher</servlet-name>
     * 		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
     * 		<init-param>
     * 			<param-name>contextConfigLocation</param-name>
     * 			<param-value>classpath*:/config-web.xml</param-value>
     * 		</init-param>
     * 		<load-on-startup>1</load-on-startup>
     * 	</servlet>
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 指定 DispatcherServlet 映射路径, 相当于在 web.xml 配置
     *
     *	<servlet-mapping>
     * 		<servlet-name>dispatcher</servlet-name>
     * 		<url-pattern>/</url-pattern>
     * 	</servlet-mapping>
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置 Filter 数组, 允许使用多个, 执行时按顺序执行, 拦截路径与 dispatcherServlet 一致
     *
     * 	<filter>
     * 		<filter-name>myFilter</filter-name>
     * 		<filter-class>com.loyofo.spa.webapp.common.filter.MyFilter</filter-class>
     * 	</filter>
     * 	<filter-mapping>
     * 		<filter-name>myFilter</filter-name>
     * 		<url-pattern>/**</url-pattern>
     * 	</filter-mapping>
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new MyFilter("filter1"), new MyFilter("filter2")};
    }


}
