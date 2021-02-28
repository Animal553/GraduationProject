package com.qianfeng.springboot.controller;

import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.entity.Department;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.page.Result;
import com.qianfeng.springboot.service.DepartmentService;
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
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    @RequiresAuthentication
    @PostMapping("/addDepartment")
    public Result addDepartment(Department department){
        Result result = null;
        Message message = null;
        try{
            message = new Message(MyEnum.OK);
            result = new Result();
            result.setMessage(message);
            departmentService.addDepartment(department);
        }catch (Exception e){
            throw new MyException(MyEnum.ADD_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/deleteDepartment")
    public Result deleteDepartment(Integer deptId){
        Result result = null;
        Message message = null;
        try{
            message = new Message(MyEnum.OK);
            result = new Result();
            result.setMessage(message);
            departmentService.deleteDepartment(deptId);
        }catch (Exception e){
            throw new MyException(MyEnum.DELETE_ERROR);
        }
        return result;
    }

    @GetMapping("/deleteDepartmentList")
    public Result deleteDepartmentList(HttpServletRequest request){
        String[] array = request.getParameterValues("array[]");
        List<Integer> deptList = new ArrayList<>();
        for (String s : array) {
            deptList.add(Integer.valueOf(s));
        }
        Result result = null;
        Message message = null;
        try {
            result = new Result();
            message = new Message(MyEnum.OK);
            departmentService.deleteDepartmentList(deptList);
            result.setMessage(message);
        }catch (Exception e){
            throw new MyException(MyEnum.DELETE_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @PostMapping("/updateDepartment")
    public Result updateDepartment(Department department){
        Result result = null;
        Message message = null;
        try{
            message = new Message(MyEnum.OK);
            result = new Result();
            result.setMessage(message);
            departmentService.updateDepartment(department);
        }catch (Exception e){
            throw new MyException(MyEnum.UPDATE_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getDepartmentList")
    public Result getDepartmentList(Integer pageNo, Integer pageSize){
        Result result = null;
        Message message = null;
        try{
            message = new Message(MyEnum.OK);
            result = new Result();
            result.setMessage(message);
            Page departmentList = departmentService.getDepartmentList(pageNo, pageSize);
            result.setData(departmentList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }


    //    @RequiresAuthentication
    @GetMapping("/getDepartmentByName")
    public Result getDepartmentByName(String deptName){
        Result result = null;
        Message message = null;
        try{
            message = new Message(MyEnum.OK);
            result = new Result();
            result.setMessage(message);
            List<Department> departmentList = departmentService.getDepartmentByName(deptName);
            result.setData(departmentList);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }

//    @RequiresAuthentication
    @GetMapping("/getDepartment")
    public Result getDepartment(Integer deptId){
        Result result = null;
        Message message = null;
        try{
            message = new Message(MyEnum.OK);
            result = new Result();
            result.setMessage(message);
            Department department = departmentService.getDepartment(deptId);
            result.setData(department);
        }catch (Exception e){
            throw new MyException(MyEnum.SELECT_ERROR);
        }
        return result;
    }
}
