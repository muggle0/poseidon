package com.sofia.poseidon.config;

import javax.sql.DataSource;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.sofia.poseidon.mapper")
public class DataSourceConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);
    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUsername;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    public DataSourceConfiguration() {
        log.info(">>>>>>>>>>>>>>>>>>>> [数据源配置] <<<<<<<<<<<<<<<<<<<<");
    }

    /**
     * 生成与spring-dao.xml对应的bean dataSource
     *
     * @return
     * @throws
     */
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource(){
        log.info(">>>>>>>>>>>>>>>>>>>> [数据源注册] <<<<<<<<<<<<<<<<<<<<");
        return new DruidDataSource();
    }

    @Bean
    public Filter statFilter(){
        log.info(">>>>>>>>>>>>>>>>>>>> [druid 过滤器] <<<<<<<<<<<<<<<<<<<<");
        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(5000);
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        return filter;
    }

}
