package com.loyofo.spa.java.config;

import com.loyofo.spa.webapp.common.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;

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
// 相当于在 spring-mvc.xml 中配置 <aop:aspectj-autoproxy />
// 由于切点切在 controller 上, 而 RootConfig 配置的应用上下文并不管理 controller, 切面找不到切入点, 无法织入
// 所以必须将 @EnableAspectJAutoProxy 注解写在 WebConfig 中, 切面才能正常织入目标切点
@EnableAspectJAutoProxy
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
     * 其中路径使用 ant 风格表达式, ** 表示下级所有级别的路径, 但下级不能为空
     *
     * 	<mvc:interceptors>
     * 		<mvc:interceptor>
     * 			<mvc:mapping path="/inter1/*"/>
     * 		    <bean class="com.loyofo.spa.java.common.interceptor.MyInterceptor" />
     * 		</mvc:interceptor>
     * 	    <mvc:interceptor>
     *          <mvc:mapping path="/inter2/*"/>
     *          <bean class="com.loyofo.spa.webapp.common.interceptor.MyInterceptor">
     *              <constructor-arg name="name" value="interceptor2"/>
     *          </bean>
     *      </mvc:interceptor>
     * 	</mvc:interceptors>
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor("interceptor1"))
                .addPathPatterns("/inter1/**");
        registry.addInterceptor(new MyInterceptor("interceptor2"))
                .addPathPatterns("/inter2/**");
        registry.addInterceptor(new MyInterceptor("切面拦截器"))
                .addPathPatterns("/aspect/**");
        registry.addInterceptor(new MyInterceptor("antPath拦截器"))
                .addPathPatterns("/ant/**");
    }

    /**
     * 添加文件上传支持, 具体文件大小限制等需要在 DispatcherServlet 的初始化类中配置,
     *
     * @see com.loyofo.spa.java.config.AppConfig#customizeRegistration(javax.servlet.ServletRegistration.Dynamic)
     *
     * 相当于在 spring-mvc.xml 中添加对应的 bean
     */
    @Bean
    public MultipartResolver multipartResolver() throws IOException {
        return new StandardServletMultipartResolver();
    }


}
