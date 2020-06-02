package com.muggle.poseidon.oa.controller;

import com.alibaba.fastjson.JSON;
import com.muggle.code.SimpleCodeTemplate;
import com.muggle.code.TableMessage;
import com.muggle.poseidon.annotation.InterfaceAction;
import com.muggle.poseidon.base.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/21
 **/
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired

   @PostMapping("/regester")
   public ResultBean<String> regester(){

   }



    public static void main(String[] args) {
        TableMessage tableMessage = new TableMessage();
        tableMessage.setUsername("root");
        tableMessage.setSwagger(true);
        tableMessage.setTableName(Arrays.asList("oa_role"));
        tableMessage.setAuthor("muggle");
        tableMessage.setBasePack("com.muggle.poseidon");
        tableMessage.setDriver("com.mysql.jdbc.Driver");
        tableMessage.setJdbcUrl("jdbc:mysql:///p_oa?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        tableMessage.setModule("poseidon");
        tableMessage.setPassword("root");
        tableMessage.setSwagger(true);
        SimpleCodeTemplate simpleCodeTemplate = new SimpleCodeTemplate(tableMessage);
        simpleCodeTemplate.createCode();
    }
}
