package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-01-04 12:34
 **/
@RestController
@RequestMapping("/poseidon/message")
public class MessageController {
    @Autowired
    UserMessageService messageService;
    @GetMapping("/unread")
    public ResultBean getMessage(){
        messageService.getMessage();
    }

    @GetMapping("/all")
    public ResultBean getAll(){
        messageService
    }
}
