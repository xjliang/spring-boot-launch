package com.xjliang.bootlaunch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xjliang.bootlaunch.generate")
public class BootLaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
