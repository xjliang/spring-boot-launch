package com.xjliang.bootlaunch.timertask;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJobs {

    // 表示方法执行完成后 5 秒再开始执行
    @Scheduled(fixedDelay = 5000)
    public void fixedDelayJob() throws InterruptedException {
        System.out.println("fixedDelay 开始:" + new Date() + Thread.currentThread());
        Thread.sleep(1 * 1000);
        System.out.println("fixedDelay 结束:" + new Date() + Thread.currentThread());
    }

    // 表示每隔 3 秒
    @Scheduled(fixedRate = 6000)
    public void fixedRateJob() throws InterruptedException {
        System.out.println("===========fixedRate 开始:" + new Date() + Thread.currentThread());
        Thread.sleep(5 * 1000);
        System.out.println("===========fixedRate 结束:" + new Date() + Thread.currentThread());
    }

    // 表示每隔 10 秒执行一次
    @Scheduled(cron = "0/10 * * * * ? ")
    public void cronJob() {
        System.out.println(
            "=========================== ...>>cron...." + new Date() + Thread.currentThread());
    }
}
