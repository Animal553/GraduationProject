package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    void addProduct(Product product);
    void deleteProduct(Integer productId);
    void updateProduct(Product product);
    List<Product> getProductList();
    Product getProduct(Integer productId);
}
