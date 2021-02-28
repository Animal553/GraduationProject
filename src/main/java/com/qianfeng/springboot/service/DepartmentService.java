package com.qianfeng.springboot.service;


import com.qianfeng.springboot.entity.Department;
import com.qianfeng.springboot.page.Page;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);
    void deleteDepartment(Integer deptId);
    void updateDepartment(Department department);
    Page getDepartmentList(Integer pageNo, Integer pageSize);
    List<Department> getDepartmentByName(String deptName);
    Department getDepartment(Integer deptId);
}
