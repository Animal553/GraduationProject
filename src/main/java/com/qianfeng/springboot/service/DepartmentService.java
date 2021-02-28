package com.qianfeng.springboot.service;


import com.qianfeng.springboot.entity.Department;
import com.qianfeng.springboot.page.Page;


public interface DepartmentService {
    void addDepartment(Department department);
    void deleteDepartment(Integer deptId);
    void updateDepartment(Department department);
    Page getDepartmentList(Integer pageNo, Integer pageSize);
    Page getDepartmentByName(Integer pageNo, Integer pageSize,String deptName);
    Department getDepartment(Integer deptId);
}
