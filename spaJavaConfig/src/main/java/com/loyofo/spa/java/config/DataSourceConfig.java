package com.loyofo.spa.java.config;

import com.zaxxer.hikari.HikariDataSource;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Properties;

@Aspect
@Component
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    {logger.info("DataSourceConfig 已创建");}

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
        properties.setProperty("cachePrepStmts", "true");
        properties.setProperty("prepStmtCacheSize", "250");
        properties.setProperty("prepStmtCacheSqlLimit", "2048");
        properties.setProperty("useServerPrepStmts", "true");
        ds.setDataSourceProperties(properties);
        return ds;
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
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 事务管理器
     */
    @Bean
    public DataSourceTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public TransactionInterceptor txAdvice(PlatformTransactionManager txManager) {
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("save*", requiredTx);
        return new TransactionInterceptor(txManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor(TransactionInterceptor txAdvice) {
        String pointCutExpression = "execution (* com.loyofo.spa.webapp.service.*.*(..))";
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(pointCutExpression);
        return new DefaultPointcutAdvisor(pointcut, txAdvice);
    }
}
