package com.qianfeng.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.springboot.entity.Customer;
import com.qianfeng.springboot.mapper.CustomerMapper;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);

    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerMapper.deleteCustomer(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public Page getCustomerList(Integer pageNo, Integer pageSize) {
        if (pageNo==null)
        {
            pageNo=1;
        }
        if (pageSize==null){
            pageSize=4;
        }
        PageHelper.startPage(pageNo,pageSize);
        List<Customer> customerList = customerMapper.getCustomerList();
        PageInfo<Customer> info = new PageInfo<>(customerList);

        Page page = new Page();
        page.setHasPre(info.isHasPreviousPage());
        page.setHasNext(info.isHasNextPage());
        page.setPageNo(info.getPageNum());
        page.setPageCount(info.getPages());
        page.setPageSize(info.getPageSize());
        page.setData(info.getList());

        return page;
    }

    @Override
    public Page getCustomerListByFlg(Integer pageNo, Integer pageSize, Integer flg) {
        if (pageNo==null)
        {
            pageNo=1;
        }
        if (pageSize==null){
            pageSize=4;
        }
        PageHelper.startPage(pageNo,pageSize);
        List<Customer> customerList = customerMapper.getCustomerListByFlg(flg);
        PageInfo<Customer> info = new PageInfo<>(customerList);

        Page page = new Page();
        page.setHasPre(info.isHasPreviousPage());
        page.setHasNext(info.isHasNextPage());
        page.setPageNo(info.getPageNum());
        page.setPageCount(info.getPages());
        page.setPageSize(info.getPageSize());
        page.setData(info.getList());

        return page;
    }

    @Override
    public List<Customer> getCustomerByName(String customerName) {
        List<Customer> customerList = customerMapper.getCustomerByName(customerName);
        return customerList;
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        Customer customer = customerMapper.getCustomer(customerId);

        return customer;
    }

    @Override
    public void updateCustomerToFlg() {
        customerMapper.updateCustomerToFlg();
    }
}
