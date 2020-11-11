package com.muggle.poseidon.controller;

import java.util.Arrays;

import com.muggle.psf.SimpleCodeGenerator;
import com.muggle.psf.TableMessage;


/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
public class TestController {
    public static void main(String[] args) {
        TableMessage tableMessage = new TableMessage();
        tableMessage.setUsername("root");
        tableMessage.setSwagger(true);
        tableMessage.setTableName(Arrays.asList("oa_dept"));
        tableMessage.setAuthor("muggle");
        tableMessage.setParentPack("com.muggle.poseidon.base");
        tableMessage.setProjectPackage("com.muggle");
        tableMessage.setDriver("com.mysql.jdbc.Driver");
        tableMessage.setJdbcUrl("jdbc:mysql:///p_oa?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        tableMessage.setModule("poseidon");
        tableMessage.setPerfix("");
        tableMessage.setPassword("root");
        tableMessage.setSwagger(true);
        SimpleCodeGenerator simpleCodeGeneratorTemplate = new SimpleCodeGenerator(tableMessage);
        simpleCodeGeneratorTemplate.createCode();
    }
}
