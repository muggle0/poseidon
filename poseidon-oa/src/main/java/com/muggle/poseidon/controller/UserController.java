package com.muggle.poseidon.controller;

import com.muggle.poseidon.service.UserService;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/4/16
 **/
@RestController
@RequestMapping("/oa/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;


    @GetMapping("/message")
    public Mono<String> test(){
        Mono<String> mono = Mono.create(monoSink -> {
            log.info("创建 Mono");
            monoSink.success("hello webflux");
        });
        Mono<String> onSubscribe = mono.doOnSubscribe(subscription -> {
            log.info("当订阅者去订阅发布者的时候，该方法会调用");
        });
        return onSubscribe;
    }

     /*
    *  Mono<String> stringMono = Mono.create(monoSink -> {

        });
    * */
}
