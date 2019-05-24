//package com.muggle.poseidon.oauth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//
///**
// * @program: poseidon
// * @description:
// * @author: muggle
// * @create: 2019-05-24
// **/
//@Configuration
//public class Oauth2ConfigBootstrap {
//    @Autowired
//    @Qualifier("primaryDataSource")
//    private DataSource dataSource;
//
//    @Bean // 声明 ClientDetails实现
//    public ClientDetailsService clientDetailsService() {
//        return new JdbcClientDetailsService(dataSource);
//    }
//}
