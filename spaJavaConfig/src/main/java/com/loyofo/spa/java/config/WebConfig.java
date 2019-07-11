package com.loyofo.spa.java.config;

import com.loyofo.spa.webapp.common.interceptor.MyInterceptor;
import com.loyofo.spa.webapp.common.interceptor.MyInterceptor2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
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
// 对应组件扫描 <context:component-scan base-package="com.loyofo.spa.webapp.controller"/>
@ComponentScan(basePackages="com.loyofo.spa.webapp.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置视图解析器, 相当于在 spring-mvc.xml 中配置
     *
     *	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     * 		<property name="prefix" value="/WEB-INF/views/" />
     * 		<property name="suffix" value=".jsp" />
     * 	</bean>
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * 静态资源映射, 相当于在 spring-mvc.xml 中配置
     *
     * <mvc:default-servlet-handler />
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 添加拦截器, 相当于在 spring-mvc.xml 中配置
     *
     * 	<mvc:interceptors>
     * 		<mvc:interceptor>
     * 		    <bean class="com.loyofo.spa.java.common.interceptor.MyInterceptor" />
     * 			<mvc:mapping path="/**"/>
     * 		</mvc:interceptor>
     * 	</mvc:interceptors>
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
    }

}
