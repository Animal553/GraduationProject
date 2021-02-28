package com.qianfeng.springboot.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.springboot.entity.Department;
import com.qianfeng.springboot.mapper.DepartmentMapper;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer deptId) {
        departmentMapper.deleteDepartment(deptId);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public Page getDepartmentList(Integer pageNo, Integer pageSize) {
        if (pageNo==null){
            pageNo=1;
        }
        if (pageSize==null){
            pageSize=4;
        }

        PageHelper.startPage(pageNo,pageSize);
        List<Department> departmentList = departmentMapper.getDepartmentList();

        PageInfo<Department> info = new PageInfo<>(departmentList);
        Page page = new Page();
        page.setHasNext(info.isHasNextPage());
        page.setHasPre(info.isHasPreviousPage());
        page.setData(info.getList());
        page.setPageCount(info.getPages());
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());

        return page;
    }

    @Override
    public List<Department> getDepartmentByName(String deptName) {
        List<Department> departmentList = departmentMapper.getDepartmentByName(deptName);
        return departmentList;
    }

    @Override
    public Department getDepartment(Integer deptId) {
        Department department = departmentMapper.getDepartment(deptId);
        return department;
    }
}
