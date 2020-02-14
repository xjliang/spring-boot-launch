package com.xjliang.bootlaunch.customlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 不是 Component, 通过配置文件配置
@Slf4j
public class MyListener3 implements ApplicationListener<MyEvent> {

    public void onApplicationEvent(MyEvent event) {
        //TODO 发送邮件代码
        log.info(String.format("%s监听到事件源：%s.", MyListener3.class.getName(), event.getSource()));
    }
}
