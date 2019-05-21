package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.UserMessage;
import com.muggle.poseidon.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return messageService.getMessage();
    }

    @GetMapping("/all")
    public ResultBean getAll(UserMessage message){
        ResultBean all = messageService.getAll(message);
        return all;
    }

    @PutMapping("/update")
    public ResultBean update(UserMessage userMessage){
        return  messageService.update(userMessage);
    }
    @PostMapping("/insert")
    public ResultBean insert(@RequestBody UserMessage userMessage){
        return  messageService.insert(userMessage);
    }

    @DeleteMapping("/delete/{id}")
    public ResultBean delete(@PathVariable String id){
        return  messageService.delete(id);
    }

    @GetMapping("/count")
    public ResultBean count(UserMessage userMessage){
        return  messageService.countNoRead(userMessage);
    }
}
