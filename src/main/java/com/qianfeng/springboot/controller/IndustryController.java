package com.qianfeng.springboot.controller;

import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.entity.Industry;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Result;
import com.qianfeng.springboot.service.IndustryService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class IndustryController {
    @Autowired
    private IndustryService industryService;

//    @RequiresAuthentication
    @GetMapping("/getIndustryList")
    public Result getIndustryList(){

        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            List<Industry> industryList = industryService.getIndustryList();
            result.setMessage(message);
            result.setData(industryList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getIndustry")
    public Result getIndustry(Integer industryId){

        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            Industry industry = industryService.getIndustry(industryId);
            result.setMessage(message);
            result.setData(industry);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }

}
