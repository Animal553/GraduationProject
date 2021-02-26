package com.qianfeng.springboot.service.impl;

import com.qianfeng.springboot.entity.Employee;
import com.qianfeng.springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void getEmployeeByName() {
       List list = new ArrayList();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        employeeService.deleteEmployeeList(list);

    }
}