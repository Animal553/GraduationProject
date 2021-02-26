package com.qianfeng.springboot.controller;

import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.entity.Level;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Result;
import com.qianfeng.springboot.service.LevelService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class LevelController {
    @Autowired
    private LevelService levelService;

//    @RequiresAuthentication
    @GetMapping("/getLevelList")
    public Result getLevelList(){

        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            List<Level> levelList = levelService.getLevelList();
            result.setMessage(message);
            result.setData(levelList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getLevel")
    public Result getLevel(Integer levelId){

        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            Level level = levelService.getLevel(levelId);
            result.setMessage(message);
            result.setData(level);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }

}
