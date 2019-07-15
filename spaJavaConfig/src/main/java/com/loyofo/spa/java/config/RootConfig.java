package com.loyofo.spa.java.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.loyofo.spa.webapp", excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = Controller.class)
})
@EnableTransactionManagement
public class RootConfig {

    @Profile("mysql")
    @Bean
    public DataSource mysqlDs() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://47.104.220.222:8063/test?useSSL=false");
        ds.setUsername("luojbin");
        ds.setPassword("luojbin2@Dev");
        ds.setMaximumPoolSize(10);
        ds.setMinimumIdle(100);
        Properties properties = new Properties();
        properties.setProperty("cachePrepStmts","true");
        properties.setProperty("prepStmtCacheSize","250");
        properties.setProperty("prepStmtCacheSqlLimit","2048");
        properties.setProperty("useServerPrepStmts","true");
        ds.setDataSourceProperties(properties);
        return  ds;
    }

    @Profile("h2")
    @Bean
    public DataSource h2Ds() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:testData.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    /**
     * 事务管理器
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager txm =  new DataSourceTransactionManager(dataSource);
        return txm;
    }
}
