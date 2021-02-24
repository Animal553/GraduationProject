package com.qianfeng.springboot.service.impl;

import com.qianfeng.springboot.entity.Employee;
import com.qianfeng.springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void getEmployeeByName() {
        Employee employee = employeeService.getEmployeeByName("猪");
        System.out.println(employee);
    }
}