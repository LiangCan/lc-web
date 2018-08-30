package com.lc.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.yml")
public class BaseJpaConfig {  
  
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";  
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show.sql";
    @Value("${spring.datasource.url}")
    String dbUrl;

    @Value("${spring.datasource.username}")
     String username;

    @Value("${spring.datasource.password}")
     String password;

    @Value("${spring.datasource.driverClassName}")
     String driverClassName;

    @Value("${spring.datasource.initialSize}")
     int initialSize;

    @Value("${spring.datasource.minIdle}")
     int minIdle;

    @Value("${spring.datasource.maxActive}")
     int maxActive;

    @Value("${spring.datasource.maxWait}")
     int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
     int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
     int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
     String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
     boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
     boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
     boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
     boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
     int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
     String filters;

    @Value("{spring.datasource.connectionProperties}")
     String connectionProperties;

//    @Value("${spring.datasource.url2}")
//     String dbUrl2;
//
//    @Value("${spring.datasource.username2}")
//     String username2;
//
//    @Value("${spring.datasource.password2}")
//     String password2;

  
    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();  
    }  
  
    protected Properties hibernateProperties() {
        Properties properties = new Properties();  
        properties.put(HIBERNATE_DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put(HIBERNATE_SHOW_SQL, "true");
        return properties;  
    }



}