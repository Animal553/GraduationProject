package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Industry;

import java.util.List;

public interface IndustryService {
    List<Industry> getIndustryList();
    Industry getIndustry(Integer industryId);
}
