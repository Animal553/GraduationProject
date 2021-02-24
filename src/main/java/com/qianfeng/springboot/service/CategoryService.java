package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoryList();
    Category getCategory(Integer categoryId);
}
