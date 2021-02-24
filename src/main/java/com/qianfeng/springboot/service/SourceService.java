package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Source;

import java.util.List;

public interface SourceService {
    List<Source> getSourceList();
    Source getSource(Integer sourceId);
}
