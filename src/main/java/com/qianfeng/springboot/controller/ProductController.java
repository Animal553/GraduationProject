package com.qianfeng.springboot.controller;

import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.entity.Product;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.page.Result;
import com.qianfeng.springboot.service.ProductService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

//    @RequiresAuthentication
    @PostMapping("/addProduct")
    public Result addProduct(Product product){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            productService.addProduct(product);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.ADD_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/deleteProduct")
    public Result deleteProduct(Integer productId){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            productService.deleteProduct(productId);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.DELETE_ERROR);
        }
        return result;
    }

    @GetMapping("/deleteProductList")
    public Result deleteProductList(HttpServletRequest request){
        String[] array = request.getParameterValues("array[]");
        List<Integer> productList = new ArrayList<>();
        for (String s : array) {
            productList.add(Integer.valueOf(s));
        }
        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            productService.deleteProductList(productList);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.DELETE_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @PostMapping("/updateProduct")
    public Result updateProduct(Product product){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            productService.updateProduct(product);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.UPDATE_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getProductList")
    public Result getProductList(Integer pageNo, Integer pageSize){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            Page productList = productService.getProductList(pageNo, pageSize);
            result.setMessage(message);
            result.setData(productList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }

    //    @RequiresAuthentication
    @GetMapping("/getProductByName")
    public Result getProductName(String productName){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            List<Product> productList = productService.getProductName(productName);
            result.setMessage(message);
            result.setData(productList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getProduct")
    public Result getProduct(Integer productId){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            Product product = productService.getProduct(productId);
            result.setMessage(message);
            result.setData(product);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }

}
