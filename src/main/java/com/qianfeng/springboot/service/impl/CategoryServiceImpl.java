package com.qianfeng.springboot.service.impl;

import com.qianfeng.springboot.entity.Category;
import com.qianfeng.springboot.mapper.CategoryMapper;
import com.qianfeng.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryList() {
        List<Category> categoryList = categoryMapper.getCategoryList();

        return categoryList;
    }

    @Override
    public Category getCategory(Integer categoryId) {
        Category category = categoryMapper.getCategory(categoryId);

        return category;
    }
}
