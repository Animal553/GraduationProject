package com.qianfeng.springboot.job;

import com.qianfeng.springboot.entity.Customer;
import com.qianfeng.springboot.service.CustomerService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.util.Date;

public class MyJob extends QuartzJobBean {

    @Autowired
    private CustomerService customerService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String msg = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("msg");

        customerService.updateCustomerToFlg();
        String time = new Date().toString();
        System.out.println("currentTime:"+time+"==>>>>"+msg);
    }
}
