package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.Contract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractMapper {
    int addContract(Contract contract);
    void deleteContract(Integer contractId);
    void updateContract(Contract contract);
    List<Contract> getContractList();
    List<Contract> getContractName(String contractName);
    Contract getContract(Integer contractId);
    void deleteContractList(List<Integer> contractIdList);
}
