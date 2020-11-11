package com.muggle.poseidon.config;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Druid 的数据源状态监控
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
//                @WebInitParam(name = "allow",value = "127.0.0.1"),
                @WebInitParam(name ="loginUsername",value = "admin"),
                @WebInitParam(name = "loginPassword",value = "123456"),
                @WebInitParam(name = "resetEnable",value = "false")//禁止html页面上reset All功能
        })
public class DruidStatViewServlet extends StatViewServlet {
    private static final Logger log = LoggerFactory.getLogger(DruidStatViewServlet.class);
    public DruidStatViewServlet() {
        log.info(">>>>>>>>>>>>>>>>>>>> [druid stateViewServlet] <<<<<<<<<<<<<<<<<<<<");
    }
}