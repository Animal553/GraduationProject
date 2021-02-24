package com.qianfeng.springboot.controller;

import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.entity.Source;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Result;
import com.qianfeng.springboot.service.SourceService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SourceController {
    @Autowired
    private SourceService sourceService;

    @RequiresAuthentication
    @GetMapping("/getSourceList")
    public Result getSourceList(){

        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            List<Source> sourceList = sourceService.getSourceList();
            result.setMessage(message);
            result.setData(sourceList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }

    @RequiresAuthentication
    @GetMapping("/getSource")
    public Result getSource(Integer sourceId){

        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            Source source = sourceService.getSource(sourceId);
            result.setMessage(message);
            result.setData(source);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }
}
