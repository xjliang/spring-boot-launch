package com.xjliang.bootlaunch;

import com.xjliang.bootlaunch.customlistener.MyListener1;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.xjliang.bootlaunch.generator")
@ServletComponentScan
public class BootLaunchApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication
            .run(BootLaunchApplication.class, args);
        context.addApplicationListener(new MyListener1());
    }

}
