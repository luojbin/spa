package com.loyofo.spa.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * springMVC 配置类, 对应 config-web.xml
 *
 * @author luojbin
 * @version 1.0
 * @date 2019/7/5 10:53
 */
@Configuration
// 对应 mvc 注解扫描 <mvc:annotation-driven/>
@EnableWebMvc
// 对应组件扫描 <context:component-scan base-package="com.loyofo.spa.xml.controller"/>
@ComponentScan(basePackages="com.loyofo.spa.java.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置视图解析器
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * 静态资源映射, 对应 <mvc:default-servlet-handler />
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }
}
