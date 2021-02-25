package com.qianfeng.springboot.config;

import com.qianfeng.springboot.job.MyJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail createJobDetail(){

        return JobBuilder.newJob(MyJob.class)//绑定job类
                .withIdentity("MyJob")//给起个名字
                .usingJobData("msg","hello quartz")//关联数据,就是向JobDetail设置一个值，可以在job类中拿到
                .storeDurably()//在没有触发器的情况下不需要删除job
                .build();
    }


    @Bean
    public Trigger createTrigger(){
        CronScheduleBuilder cronScheduleBuilder =CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(createJobDetail())
                .withIdentity("MyJobTrigger")
                .withSchedule(cronScheduleBuilder)//绑定定时执行的规则
                .build();
    }
}
