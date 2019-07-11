package com.loyofo.spa.java.config;

import com.loyofo.spa.webapp.common.filter.MyFilter;
import com.loyofo.spa.webapp.common.listener.ReqListener;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * WebApplicationInitializer 的 onStartup 方法, 允许添加任意多个 servlet/filter/listener
 *
 * 相当于在 web.xml 中配置需要的 servlet/filter/listener
 */
public class ServletConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 添加 filter3 和 filter4
        String filter3 = "filter3";
        String filter4 = "filter4";
        servletContext.addFilter(filter3, new MyFilter(filter3))
                .addMappingForUrlPatterns(null, false, "/"+ filter3 +"/*" );
        servletContext.addFilter(filter4, new MyFilter(filter4))
                .addMappingForUrlPatterns(null, false, "/" + filter4 + "/*" );

        // 添加监听器
        servletContext.addListener(ReqListener.class);
    }
}
