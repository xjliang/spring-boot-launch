package com.xjliang.bootlaunch.controller;

import com.xjliang.bootlaunch.customlistener.MyEvent;
import javax.annotation.Resource;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListenerController {

    @Resource
    ConfigurableApplicationContext applicationContext;

    @RequestMapping("/publish")
    public String hello() {
        //TODO 业务处理

        applicationContext.publishEvent(new MyEvent("邮件内容"));

        return "OK";
    }
}
