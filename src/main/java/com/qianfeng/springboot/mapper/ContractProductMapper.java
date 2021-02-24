package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.ContractProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractProductMapper {
    void addContractProduct(ContractProduct contractProduct);
    void deleteContractProduct(Integer cpId);
    void updateContractProduct(ContractProduct contractProduct);
    List<ContractProduct> getContractProductList();
    ContractProduct getContractProduct(Integer cpId);

}
