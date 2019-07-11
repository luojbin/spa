package com.loyofo.spa.java.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "com.loyofo.spa.webapp", excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = Controller.class)
})
public class RootConfig {
}
