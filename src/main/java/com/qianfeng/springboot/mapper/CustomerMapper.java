package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    void addCustomer(Customer customer);
    void deleteCustomer(Integer customerId);
    void updateCustomer(Customer customer);
    List<Customer> getCustomerList();
    List<Customer> getCustomerListByFlg(Integer flg);
    Customer getCustomer(Integer customerId);
    void updateCustomerToFlg();
}
