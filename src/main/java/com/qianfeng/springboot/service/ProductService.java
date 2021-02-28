package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Product;
import com.qianfeng.springboot.page.Page;

import java.util.List;


public interface ProductService {
    void addProduct(Product product);
    void deleteProduct(Integer productId);
    void updateProduct(Product product);
    Page getProductList(Integer pageNo, Integer pageSize);
    List<Product> getProductName(String productName);
    Product getProduct(Integer productId);
    void deleteProductList(List<Integer> productIdList);
}
