package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Customer;
import com.qianfeng.springboot.page.Page;

import java.util.List;


public interface CustomerService {
    void addCustomer(Customer customer);
    void deleteCustomer(Integer customerId);
    void updateCustomer(Customer customer);
    Page getCustomerList(Integer pageNo, Integer pageSize);
    Page getCustomerListByFlg(Integer pageNo, Integer pageSize, Integer flg);
    List<Customer> getCustomerByName(String customerName, Integer flg);
    Customer getCustomer(Integer customerId);
    void updateCustomerToFlg();
    void deleteCustomerList(List<Integer> customerIdList);
}
