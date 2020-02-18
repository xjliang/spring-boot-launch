package com.xjliang.bootlaunch.timertask;

import java.util.Date;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzSimpleTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext)
        throws JobExecutionException {
        System.out.println("quartz 简单的定时任务执行时间：" + new Date().toString());
    }
}
