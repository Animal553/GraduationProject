package com.qianfeng.springboot.service.impl;

import com.qianfeng.springboot.entity.Source;
import com.qianfeng.springboot.mapper.SourceMapper;
import com.qianfeng.springboot.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    private SourceMapper sourceMapper;

    @Override
    public List<Source> getSourceList() {
        List<Source> sourceList = sourceMapper.getSourceList();
        return sourceList;
    }

    @Override
    public Source getSource(Integer sourceId) {
        Source source = sourceMapper.getSource(sourceId);
        return source;
    }
}
