package com.muggle.poseidon.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Description
 * Date 2021/3/28
 * Created by muggle
 */
@Slf4j
@Configuration
public class DatabaseAutoConfig {


    @Value("${spring.datasource.url}")
    private String datasourceUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.flyway.enabled}")
    private Boolean flywayEnabled;

    @PostConstruct
    public void dataSource(){
        if (!flywayEnabled){
            return;
        }

        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(datasourceUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        try {
            Class.forName(driverClassName);
            String url01 = datasourceUrl.substring(0,datasourceUrl.indexOf("?"));
            String url02 = url01.substring(0,url01.lastIndexOf("/"))
                .concat("?serverTimezone=UTC");
            String datasourceName = url01.substring(url01.lastIndexOf("/")+1);
            // 连接已经存在的数据库，如：mysql
            Connection connection = DriverManager.getConnection(url02, username, password);
            Statement statement = connection.createStatement();
            // 创建数据库
            statement.executeUpdate("create database if not exists `" + datasourceName + "` default character set utf8 COLLATE utf8_general_ci");
            statement.close();
            connection.close();
            datasource.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
