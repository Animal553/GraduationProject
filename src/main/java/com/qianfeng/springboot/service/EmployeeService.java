package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Employee;
import com.qianfeng.springboot.page.Page;


public interface EmployeeService {
    void addEmployee(Employee employee);
    void deleteEmployee(Integer empId);
    void updateEmployee(Employee employee);
    Page getEmployeeList(Integer pageNo, Integer pageSize);
    Employee getEmployee(Integer empId);
    Employee getEmployeeByName(String empName);
    Employee getEmployeeByEmail(String email);
}
