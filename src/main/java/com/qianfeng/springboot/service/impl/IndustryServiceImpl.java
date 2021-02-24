package com.qianfeng.springboot.service.impl;

import com.qianfeng.springboot.entity.Industry;
import com.qianfeng.springboot.mapper.IndustryMapper;
import com.qianfeng.springboot.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    private IndustryMapper industryMapper;

    @Override
    public List<Industry> getIndustryList() {
        List<Industry> industryList = industryMapper.getIndustryList();

        return industryList;
    }

    @Override
    public Industry getIndustry(Integer industryId) {
        Industry industry = industryMapper.getIndustry(industryId);

        return industry;
    }
}
