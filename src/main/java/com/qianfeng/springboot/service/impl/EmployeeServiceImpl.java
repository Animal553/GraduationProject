package com.qianfeng.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.springboot.entity.Employee;
import com.qianfeng.springboot.mapper.EmployeeMapper;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void addEmployee(Employee employee) {

        employeeMapper.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer empId) {

        employeeMapper.deleteEmployee(empId);
    }

    @Override
    public void updateEmployee(Employee employee) {

        employeeMapper.updateEmployee(employee);
    }

    @Override
    public Page getEmployeeList(Integer pageNo, Integer pageSize) {
        if (pageNo==null){
            pageNo=1;
        }
        if (pageSize==null){
            pageSize=4;
        }

        PageHelper.startPage(pageNo,pageSize);
        List<Employee> employeeList = employeeMapper.getEmployeeList();
        PageInfo<Employee> info = new PageInfo<>(employeeList);

        Page page = new Page();
        page.setHasNext(info.isHasNextPage());
        page.setHasPre(info.isHasPreviousPage());
        page.setPageCount(info.getPages());
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setData(info.getList());

        return page;
    }

    @Override
    public Employee getEmployee(Integer empId) {

        Employee employee = employeeMapper.getEmployee(empId);

        return employee;
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        Employee employee = employeeMapper.getEmployeeByEmail(email);
        return employee;

    }
}
