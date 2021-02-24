package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Customer;
import com.qianfeng.springboot.page.Page;


public interface CustomerService {
    void addCustomer(Customer customer);
    void deleteCustomer(Integer customerId);
    void updateCustomer(Customer customer);
    Page getCustomerList(Integer pageNo, Integer pageSize);
    Customer getCustomer(Integer customerId);
}
