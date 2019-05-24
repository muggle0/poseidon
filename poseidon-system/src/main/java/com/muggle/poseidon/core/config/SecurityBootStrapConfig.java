package com.muggle.poseidon.core.config;

import com.muggle.poseidon.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: poseidon
 * @description: security配置辅助类
 * @author: muggle
 * @create: 2019-05-21
 **/
@Configuration
public class SecurityBootStrapConfig {
    @Bean
    @ConfigurationProperties(prefix = "poseidon.security")
    public SecurityProperties getModel() {
        return new SecurityProperties();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
