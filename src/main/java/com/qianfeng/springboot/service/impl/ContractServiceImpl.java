package com.qianfeng.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.springboot.entity.Contract;
import com.qianfeng.springboot.mapper.ContractMapper;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public void addContract(Contract contract) {
        contractMapper.addContract(contract);
    }

    @Override
    public void deleteContract(Integer contractId) {
        contractMapper.deleteContract(contractId);
    }

    @Override
    public void updateContract(Contract contract) {
        contractMapper.updateContract(contract);
    }

    @Override
    public Page getContractList(Integer pageNo, Integer pageSize) {

        if (pageNo==null){
            pageNo=1;
        }
        if (pageSize==null)
        {
            pageSize=4;
        }

        PageHelper.startPage(pageNo,pageSize);
        List<Contract> contractList = contractMapper.getContractList();
        PageInfo<Contract> info = new PageInfo<>(contractList);

        Page page = new Page();
        page.setHasPre(info.isHasPreviousPage());
        page.setHasNext(info.isHasNextPage());
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setPageCount(info.getPages());
        page.setData(info.getList());

        return page;
    }

    @Override
    public Contract getContract(Integer contractId) {
        Contract contract = contractMapper.getContract(contractId);

        return contract;
    }
}
