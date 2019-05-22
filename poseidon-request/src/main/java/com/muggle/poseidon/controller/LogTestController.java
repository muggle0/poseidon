package com.muggle.poseidon.controller;


import com.muggle.poseidon.entity.LoggingEvent;
import com.muggle.poseidon.logrep.LoggingEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/log")
@Slf4j
public class LogTestController {
//    private static final Logger log = LoggerFactory.getLogger("logstash");
    @Autowired
    LoggingEventRepository repository;

    @GetMapping("/")
    public String test(){
        log.info("sssssssssssssss");
//        Iterable<LoggingEvent> all = repository.findAll();

        return "sss";

    }
}
