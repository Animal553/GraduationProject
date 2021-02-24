package com.qianfeng.springboot.mapper;

import com.qianfeng.springboot.entity.Level;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LevelMapper {
    List<Level> getLevelList();
    Level getLevel(Integer levelId);
}
