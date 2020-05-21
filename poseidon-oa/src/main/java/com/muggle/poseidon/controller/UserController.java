package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

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
    public Mono<ResultBean<String>> test() {
        Mono<ResultBean<String>> mono = Mono.create(monoSink -> {
            log.info("创建 Mono");
            monoSink.success(ResultBean.successData("你好"));
        });
//        return mono;
        return ResultBean.successData("test").covert();
    }


    @GetMapping("/message0")
    public ResultBean<String> test0() {
//        return mono;
        return ResultBean.successData("test");
    }

    @GetMapping(value = "/message1", produces = { "application/json;charset=utf-8" })
    public Flux<String> test2() {
//        return mono;
        Flux<String> map = Flux.interval(Duration.ofSeconds(1)).map(aLong -> {

                    if (aLong == 10) {
                        throw new RuntimeException("");
                    }
                    return "第" + aLong + "次推送";
                }
        );
        return map;
    }

}
