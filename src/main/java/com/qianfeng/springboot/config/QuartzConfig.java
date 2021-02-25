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
                .usingJobData("msg","定时任务的执行...")//关联数据,就是向JobDetail设置一个值，可以在job类中拿到
                .storeDurably()//在没有触发器的情况下不需要删除job
                .build();
    }


    @Bean
    public Trigger createTrigger(){

        //0/1 * * * * ?
        //59 59 23 * * ?
        CronScheduleBuilder cronScheduleBuilder =CronScheduleBuilder.cronSchedule("59 59 23 * * ?");//定时任务的设置
        return TriggerBuilder.newTrigger()//创建新的调度器的对象
                .forJob(createJobDetail())//绑定jobDetail
                .withIdentity("MyJobTrigger")
                .withSchedule(cronScheduleBuilder)//绑定定时执行的规则
                .build();
    }
}
