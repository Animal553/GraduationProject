package com.qianfeng.springboot.controller;

import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.entity.Category;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Result;
import com.qianfeng.springboot.service.CategoryService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    @RequiresAuthentication
    @GetMapping("/getCategoryList")
    public Result getCategoryList(){

        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            List<Category> categoryList = categoryService.getCategoryList();
            result.setMessage(message);
            result.setData(categoryList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getCategory")
    public Result getCategory(Integer categoryId){

        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            Category category = categoryService.getCategory(categoryId);
            result.setMessage(message);
            result.setData(category);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }

}
