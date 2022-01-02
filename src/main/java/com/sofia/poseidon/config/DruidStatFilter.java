package com.sofia.poseidon.config;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions",
                        value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") })
public class DruidStatFilter extends WebStatFilter {
    private static final Logger log = LoggerFactory.getLogger(DruidStatFilter.class);
    public DruidStatFilter() {
        log.info(">>>>>>>>>>>>>>>>>>>> [druid statefilter] <<<<<<<<<<<<<<<<<<<<");
    }
}
// http://localhost:9000/druid/webapp.html