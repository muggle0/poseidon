package com.muggle.poseidon.service;

import com.muggle.poseidon.model.EmailBean;

public interface EmailService {
    void sendSimpleMail(EmailBean mailBean);

    void sendMailForHtml(EmailBean mailBean);
}
