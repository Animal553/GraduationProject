package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Product;
import com.qianfeng.springboot.page.Page;


public interface ProductService {
    void addProduct(Product product);
    void deleteProduct(Integer productId);
    void updateProduct(Product product);
    Page getProductList(Integer pageNo, Integer pageSize);
    Page getProductName(Integer pageNo, Integer pageSize,String productName);
    Product getProduct(Integer productId);
}
