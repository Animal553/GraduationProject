package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    void addDepartment(Department department);
    void deleteDepartment(Integer deptId);
    void updateDepartment(Department department);
    List<Department> getDepartmentList();
    List<Department> getDepartmentByName(String empName);
    Department getDepartment(Integer deptId);
}
