package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.ContractProduct;
import com.qianfeng.springboot.page.Page;


public interface ContractProductService {
    void addContractProduct(ContractProduct contractProduct);
    void deleteContractProduct(Integer cpId);
    void updateContractProduct(ContractProduct contractProduct);
    Page getContractProductList(Integer pageNo, Integer pageSize);
    ContractProduct getContractProduct(Integer cpId);
}
