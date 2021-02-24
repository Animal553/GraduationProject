package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.Source;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SourceMapper {
    List<Source> getSourceList();
    Source getSource(Integer sourceId);
}
