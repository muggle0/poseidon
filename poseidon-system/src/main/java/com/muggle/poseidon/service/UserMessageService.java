package com.muggle.poseidon.service;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.UserMessage;

public interface UserMessageService {
    ResultBean getMessage();

    ResultBean getAll(UserMessage message);

    ResultBean update(UserMessage userMessage);

    ResultBean insert(UserMessage userMessage);

    ResultBean delete(String id);

    ResultBean countNoRead(UserMessage userMessage);
}
