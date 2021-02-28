package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.Customer;
import com.qianfeng.springboot.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    void addCustomer(Customer customer);
    void deleteCustomer(Integer customerId);
    void updateCustomer(Customer customer);
    List<Customer> getCustomerList();
    List<Customer> getCustomerListByFlg(Integer flg);
    List<Customer> getCustomerByName(@Param("customerName") String customerName ,@Param("flg") Integer flg);
    Customer getCustomer(Integer customerId);
    void updateCustomerToFlg();
    void deleteCustomerList(List<Integer> customerIdList);
}
