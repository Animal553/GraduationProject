package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> getCategoryList();
    Category getCategory(Integer categoryId);

}
