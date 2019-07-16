package com.loyofo.spa.java.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(
        // basePackages = "com.loyofo.spa",
        basePackages = {"com.loyofo.spa.webapp.common.aspect", "com.loyofo.spa.java.config"},
        excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = Controller.class)
        , @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
// 只在声明该注解的上下文内查找 @Transactional 注解,
// 若定义在 DispatcherServlet 的上下文, 则无法为 spring 应用上下文的 bean 添加事务
// @EnableTransactionManagement
// 只在声明该注解的上下文内查找被切组件, 如果有多个上下文都有各自的切面bean, 则需要在不同的上下文中重复添加注解
// 此处的注解是为了添加 DataSourceConfig 与 service 层上的切面组件,
// @EnableAspectJAutoProxy
public class RootConfig {
    private static Logger logger = LoggerFactory.getLogger(RootConfig.class);

    {
        logger.info("RootConfig 已创建");
    }
}
