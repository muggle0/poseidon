package com.sofia.poseidon.config;


import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MybatisPlusConfig {

    private static final Logger log = LoggerFactory.getLogger(MybatisPlusConfig.class);
    @Autowired
    private DataSource dataSource;
    @Value("${mybatis-plus.global-config.id-type}")
    private Integer idType;
    @Value("${mybatis-plus.global-config.field-strategy}")
    private int fieldStrategy;
    @Value("${mybatis-plus.global-config.capital-mode}")
    private boolean capitalMode;
    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;
    @Value("${mybatis-plus.type-aliases-package}")
    private String typeAliasesPackage;
    @Value("${mybatis-plus.global-config.refresh-mapper}")
    private boolean refreshMapper;

    public MybatisPlusConfig() {
        log.info(">>>>>>>>>>>>>>>>>>>> [mybatis 配置] <<<<<<<<<<<<<<<<<<<<");
    }

    @Bean(name = "globalConfig")
    public GlobalConfig globalConfiguration() {
        log.info(">>>>>>>>>>>>>>>>>>>> [初始化GlobalConfiguration] <<<<<<<<<<<<<<<<<<<<");
        GlobalConfig config = new GlobalConfig();
        config.setBanner(false);
        return config;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactoryBean(@Qualifier(value = "globalConfig") GlobalConfig configuration) throws Exception {
        log.info(">>>>>>>>>>>>>>>>>>>> [初始化SqlSessionFactory] <<<<<<<<<<<<<<<<<<<<");
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        pageInterceptor.setProperties(properties);

        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setGlobalConfig(configuration);
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
            sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        log.info(">>>>>>>>>>>>>>>>>>>> [初始化transactionManager] <<<<<<<<<<<<<<<<<<<<");
        return new DataSourceTransactionManager(dataSource);
    }

}
