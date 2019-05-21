package com.muggle.poseidon.service;

import com.muggle.poseidon.entity.EmailBean;

public interface EmailService {
    void  sendSimpleMail(EmailBean mailBean);

    void sendMailForHtml(EmailBean mailBean);
    void sendCode(String recipient,String context);
}
