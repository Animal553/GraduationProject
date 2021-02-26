package com.qianfeng.springboot.controller;

import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.entity.ContractProduct;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.page.Result;
import com.qianfeng.springboot.service.ContractProductService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractProductController {

    @Autowired
    private ContractProductService contractProductService;

//    @RequiresAuthentication
    @PostMapping("/addContractProduct")
    public Result addContractProduct(ContractProduct contractProduct){
        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            contractProductService.addContractProduct(contractProduct);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.ADD_ERROR);
        }

        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/deleteContractProduct")
    public Result deleteContractProduct(Integer cpId){
        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            contractProductService.deleteContractProduct(cpId);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.DELETE_ERROR);
        }

        return result;
    }

//    @RequiresAuthentication
    @PostMapping("/updateContractProduct")
    public Result updateContractProduct(ContractProduct contractProduct){
        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            contractProductService.updateContractProduct(contractProduct);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.UPDATE_ERROR);
        }

        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getContractProductList")
    public Result getContractProductList(Integer pageNo, Integer pageSize){
        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            Page contractProductList = contractProductService.getContractProductList(pageNo, pageSize);
            result.setData(contractProductList);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getContractProduct")
    public Result getContractProduct(Integer cpId){
        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            ContractProduct contractProduct = contractProductService.getContractProduct(cpId);
            result.setData(contractProduct);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }

}
