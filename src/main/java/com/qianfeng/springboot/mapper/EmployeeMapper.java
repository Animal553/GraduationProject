package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    void addEmployee(Employee employee);
    void deleteEmployee(Integer empId);
    void updateEmployee(Employee employee);
    List<Employee> getEmployeeList();
    Employee getEmployee(Integer empId);
    Employee getEmployeeByName(String empName);
    Employee getEmployeeByEmail(String email);
    void deleteEmployeeList(List<Integer> empIdList);
}
