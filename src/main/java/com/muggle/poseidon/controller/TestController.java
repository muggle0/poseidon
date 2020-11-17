package com.muggle.poseidon.controller;

import java.util.Arrays;
import java.util.Map;

import com.muggle.poseidon.annotation.InterfaceAction;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.psf.SimpleCodeGenerator;
import com.muggle.psf.TableMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@RestController
public class TestController {
    public static void main(String[] args) {
        TableMessage tableMessage = new TableMessage();
        tableMessage.setUsername("root");
        tableMessage.setSwagger(true);
        tableMessage.setTableName(Arrays.asList("oa_role"));
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
    @PostMapping("/test.json")
    @InterfaceAction
    public ResultBean test(@RequestBody Map<String,String> map){
        System.out.println(map);
        return ResultBean.success();
    }
}
