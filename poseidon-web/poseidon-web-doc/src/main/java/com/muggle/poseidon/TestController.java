package com.muggle.poseidon;

import com.muggle.poseidon.entity.EmailBean;
import com.muggle.poseidon.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: poseidon
 * @description: 测试
 * @author: muggle
 * @create: 2019-04-03
 **/
@RestController
public class TestController {
    @Autowired
    EmailService emailService;

    @GetMapping("/public/web/test")
    public String test(){
        int i=2;
        while (i<3){
            EmailBean emailBean = new EmailBean();
            emailBean.setRecipient("renb5776@tom.com").setContent("您好<br>我觉得你是个铁憨憨，还处对象，回家种田吧兄弟").setSubject("系统提示");
            emailService.sendSimpleMail(emailBean);
            emailBean.setRecipient("dpg8qix8p@tom.com");
            emailService.sendSimpleMail(emailBean);
            System.out.println("test");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "ets";
    }
}
