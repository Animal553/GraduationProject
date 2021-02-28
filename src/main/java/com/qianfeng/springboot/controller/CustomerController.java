package com.qianfeng.springboot.controller;

import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.entity.Customer;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.page.Result;
import com.qianfeng.springboot.service.CustomerService;
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
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    @RequiresAuthentication
    @PostMapping("/addCustomer")
    public Result addCustomer(Customer customer){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            customerService.addCustomer(customer);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.ADD_ERROR);
        }

        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/deleteCustomer")
    public Result deleteCustomer(Integer customerId){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            customerService.deleteCustomer(customerId);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.DELETE_ERROR);
        }

        return result;
    }

    @GetMapping("/deleteCustomerList")
    public Result deleteCustomerList(HttpServletRequest request){
        String[] array = request.getParameterValues("array[]");
        List<Integer> customerList = new ArrayList<>();
        for (String s : array) {
            customerList.add(Integer.valueOf(s));
        }
        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            customerService.deleteCustomerList(customerList);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.DELETE_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @PostMapping("/updateCustomer")
    public Result updateCustomer(Customer customer){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            customerService.updateCustomer(customer);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.UPDATE_ERROR);
        }

        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getCustomerList")
    public Result getCustomerList(Integer pageNo, Integer pageSize){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            Page customerList = customerService.getCustomerList(pageNo, pageSize);
            result.setMessage(message);
            result.setData(customerList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getCustomer")
    public Result getCustomer(Integer customerId){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            Customer customer = customerService.getCustomer(customerId);
            result.setMessage(message);
            result.setData(customer);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }

    @GetMapping("/getCustomerListByFlg")
    public Result getCustomerListByFlg(Integer pageNo, Integer pageSize,Integer flg){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            Page customerList = customerService.getCustomerListByFlg(pageNo, pageSize, flg);
            result.setMessage(message);
            result.setData(customerList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }



    @GetMapping("/getCustomerByName")
    public Result getCustomerByName(String customerName,Integer flg){
        Result result = null;
        Message message = null;

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            List<Customer> customerList = customerService.getCustomerByName(customerName,flg);
            result.setMessage(message);
            result.setData(customerList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }

        return result;
    }

}
