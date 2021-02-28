package com.qianfeng.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.springboot.entity.Product;
import com.qianfeng.springboot.mapper.ProductMapper;
import com.qianfeng.springboot.page.Page;
import com.qianfeng.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);

    }

    @Override
    public void deleteProduct(Integer productId) {
        productMapper.deleteProduct(productId);

    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);

    }

    @Override
    public Page getProductList(Integer pageNo,Integer pageSize) {
        if (pageNo==null){
            pageNo=1;
        }
        if (pageSize==null){
            pageSize=4;
        }

        PageHelper.startPage(pageNo,pageSize);
        List<Product> productList = productMapper.getProductList();
        PageInfo<Product> info = new PageInfo<>(productList);

        Page page = new Page();
        page.setHasPre(info.isHasPreviousPage());
        page.setHasNext(info.isHasNextPage());
        page.setPageSize(info.getPageSize());
        page.setPageNo(info.getPageNum());
        page.setPageCount(info.getPages());
        page.setData(info.getList());

        return page;
    }

    @Override
    public List<Product> getProductName(String productName) {
        List<Product> productList = productMapper.getProductName(productName);

        return productList;
    }

    @Override
    public Product getProduct(Integer productId) {
        Product product = productMapper.getProduct(productId);

        return product;
    }
}
