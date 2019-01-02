package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.model.EmailBean;
import com.muggle.poseidon.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
    @Value("${email.server}")
    private String server;
    @Autowired
    private JavaMailSender  javaMailSender;

    @Override
    public void sendSimpleMail(EmailBean mailBean) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件发送人
        simpleMailMessage.setFrom(server);
        //邮件接收人
        simpleMailMessage.setTo(mailBean.getRecipient());
        //邮件主题
        simpleMailMessage.setSubject(mailBean.getSubject());
        //邮件内容
        simpleMailMessage.setText(mailBean.getContent());
        javaMailSender.send(simpleMailMessage);
    }
    @Override
    public void sendMailForHtml(EmailBean mailBean){
        StringBuffer context=new StringBuffer();
        context.append("<h3> 嗨，小伙伴,poseidon 给你回信了</h3><br>");
        context.append(mailBean.getSubject());
        mailBean.setSubject(context.toString());
        sendSimpleMail(mailBean);
    }
}
