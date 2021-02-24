package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.Industry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndustryMapper {
    List<Industry> getIndustryList();
    Industry getIndustry(Integer industryId);
}
