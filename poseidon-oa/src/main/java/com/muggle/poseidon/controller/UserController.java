package com.muggle.poseidon.controller;

import com.muggle.code.SimpleCodeTemplate;
import com.muggle.code.TableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/21
 **/
@RestController
public class UserController {
//    @Autowired

    public static void main(String[] args) {

        TableMessage tableMessage = new TableMessage();
        tableMessage.setUsername("root");
        tableMessage.setSwagger(true);
        tableMessage.setTableName(Arrays.asList("menu"));

        tableMessage.setAuthor("muggle");
        tableMessage.setBasePack("com.muggle");
        tableMessage.setDriver("com.mysql.jdbc.Driver");
        tableMessage.setJdbcUrl("jdbc:mysql://49.233.148.110/poseidon_cloud_a?useUnicode=true&characterEncoding=utf8");
        tableMessage.setModule("user");
        tableMessage.setPassword("root");
        tableMessage.setSwagger(true);
        SimpleCodeTemplate simpleCodeTemplate = new SimpleCodeTemplate(tableMessage);
        simpleCodeTemplate.createCode();
    }
}
