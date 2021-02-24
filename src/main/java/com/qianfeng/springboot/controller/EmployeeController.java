package com.qianfeng.springboot.controller;

import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.entity.Employee;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.page.Result;
import com.qianfeng.springboot.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//    @RequiresAuthentication
    @PostMapping("/addEmployee")
    public Result addEmployee(Employee employee){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            employeeService.addEmployee(employee);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.ADD_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/deleteEmployee")
    public Result deleteEmployee(Integer empId){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            employeeService.deleteEmployee(empId);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.DELETE_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @PostMapping("/updateEmployee")
    public Result updateEmployee(Employee employee){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            employeeService.updateEmployee(employee);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.UPDATE_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getEmployeeList")
    public Result getEmployeeList(Integer pageNo, Integer pageSize){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            Page employeeList = employeeService.getEmployeeList(pageNo, pageSize);
            result.setMessage(message);
            result.setData(employeeList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getEmployee")
    public Result getEmployee(Integer empId){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            Employee employee = employeeService.getEmployee(empId);
            result.setMessage(message);
            result.setData(employee);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }

    @GetMapping("/getEmployeeByName")
    public Result getEmployeeByName(String empName){
        Result result = null;
        Message message = null;

        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            Employee employee = employeeService.getEmployeeByName(empName);
            result.setMessage(message);
            result.setData(employee);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }

    @PostMapping("/login")
    public Result login(String email, String password, String rem){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(email,password);
        Result result = null;
        Message message = null;
        //记住我，前端传来的rem不是空就是记住我，否则就是不是记住我
        if (rem!=null){
            token.setRememberMe(true);
        }else {
            token.setRememberMe(false);
        }

        try{
            result = new Result();
            message = new Message(MyEnum.OK);
            subject.login(token);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.LOGIN_ERROR);
        }

        return result;
    }
}
