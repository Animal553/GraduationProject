package com.qianfeng.springboot.service;

import com.qianfeng.springboot.entity.Level;

import java.util.List;

public interface LevelService {
    List<Level> getLevelList();
    Level getLevel(Integer levelId);
}
