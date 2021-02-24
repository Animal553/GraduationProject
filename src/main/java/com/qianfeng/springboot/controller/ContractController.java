package com.qianfeng.springboot.controller;

import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.entity.Contract;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.page.Result;
import com.qianfeng.springboot.service.ContractService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.File;

@RestController
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping("/addContract")
    public Result addContract(Contract contract,@PathParam("file") MultipartFile file){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            contractService.addContract(contract,file);
            result.setMessage(message);
            result.setData(contract.getContractId());
        }catch (Exception e){
            throw new MyException(MyEnum.ADD_ERROR);
        }

        return result;
    }

    @RequiresAuthentication
    @GetMapping("/deleteContract")
    public Result deleteContract(Integer contractId){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            contractService.deleteContract(contractId);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.DELETE_ERROR);
        }

        return result;
    }

    @RequiresAuthentication
    @PostMapping("/updateContract")
    public Result updateContract(Contract contract){
        Result result = null;
        Message message = null;
        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            contractService.updateContract(contract);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.UPDATE_ERROR);
        }

        return result;
    }

    @RequiresAuthentication
    @GetMapping("/getContractList")
    public Result getContractList(Integer pageNo,Integer pageSize){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            Page contractList = contractService.getContractList(pageNo, pageSize);
            result.setMessage(message);
            result.setData(contractList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }

    @RequiresAuthentication
    @GetMapping("/getContract")
    public Result getContract(Integer contractId){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            Contract contract = contractService.getContract(contractId);
            result.setMessage(message);
            result.setData(contract);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }
}
