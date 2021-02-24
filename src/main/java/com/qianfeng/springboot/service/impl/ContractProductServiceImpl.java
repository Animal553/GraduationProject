package com.qianfeng.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.springboot.entity.ContractProduct;
import com.qianfeng.springboot.mapper.ContractProductMapper;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.service.ContractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ContractProductServiceImpl implements ContractProductService {

    @Autowired
    private ContractProductMapper contractProductMapper;

    @Override
    public void addContractProduct(ContractProduct contractProduct) {
        contractProductMapper.addContractProduct(contractProduct);

    }

    @Override
    public void deleteContractProduct(Integer cpId) {
        contractProductMapper.deleteContractProduct(cpId);

    }

    @Override
    public void updateContractProduct(ContractProduct contractProduct) {
        contractProductMapper.updateContractProduct(contractProduct);

    }

    @Override
    public Page getContractProductList(Integer pageNo, Integer pageSize) {
        if (pageNo==null)
        {
            pageNo=1;
        }
        if (pageSize==null){
            pageSize=4;
        }

        PageHelper.startPage(pageNo,pageSize);
        List<ContractProduct> contractProductList = contractProductMapper.getContractProductList();
        PageInfo<ContractProduct> info = new PageInfo<>(contractProductList);

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
    public ContractProduct getContractProduct(Integer cpId) {
        ContractProduct contractProduct = contractProductMapper.getContractProduct(cpId);

        return contractProduct;
    }
}
