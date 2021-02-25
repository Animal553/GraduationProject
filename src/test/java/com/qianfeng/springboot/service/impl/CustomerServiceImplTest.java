package com.qianfeng.springboot.service.impl;

import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void getCustomerListByFlg() {

        Page list = customerService.getCustomerListByFlg(1, 5, 2);
        System.out.println(list);
    }
}