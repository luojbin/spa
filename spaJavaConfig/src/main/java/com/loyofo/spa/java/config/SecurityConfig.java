package com.loyofo.spa.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    {
        System.out.println("spring security 配置");
    }
    /**
     * 配置 用户信息存储
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                // 指定用户名和密码, 并用 authorities 授权
                .withUser("test").password("test").authorities("TEST", "ROLE_USER").and()
                // roles() 方法是 authorities() 的语法糖, 自动添加 `ROLE_` 的前缀, 效果一样
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }

    /**
     * 配置如何通过拦截器保护请求, 指定哪些请求需要认证, 哪些请求不需要认证, 哪些请求需要特定的权限
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();

    }

    /**
     * 配置 spring security 的 Filter 链, 默认即可
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
