package com.muggle.poseidon.config;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions",
                        value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") })
@Configuration
public class DruidStatFilter extends WebStatFilter {

}