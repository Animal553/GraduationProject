package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Employee;
import com.qianfeng.springboot.page.Page;

import java.util.List;


public interface EmployeeService {
    void addEmployee(Employee employee);
    void deleteEmployee(Integer empId);
    void updateEmployee(Employee employee);
    Page getEmployeeList(Integer pageNo, Integer pageSize);
    Employee getEmployee(Integer empId);
    List<Employee> getEmployeeByName(String empName);
    Employee getEmployeeByEmail(String email);
    void deleteEmployeeList(List<Integer> empIdList);
}
