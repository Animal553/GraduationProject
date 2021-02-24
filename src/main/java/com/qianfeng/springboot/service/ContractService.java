package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Contract;
import com.qianfeng.springboot.page.Page;
import org.springframework.web.multipart.MultipartFile;


public interface ContractService {
    void addContract(Contract contract, MultipartFile file);
    void deleteContract(Integer contractId);
    void updateContract(Contract contract);
    Page getContractList(Integer pageNo, Integer pageSize);
    Contract getContract(Integer contractId);
}
