package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Contract;
import com.qianfeng.springboot.page.Page;


public interface ContractService {
    void addContract(Contract contract);
    void deleteContract(Integer contractId);
    void updateContract(Contract contract);
    Page getContractList(Integer pageNo, Integer pageSize);
    Contract getContract(Integer contractId);
}
