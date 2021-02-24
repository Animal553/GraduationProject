package com.qianfeng.springboot.service.impl;

import com.qianfeng.springboot.entity.Level;
import com.qianfeng.springboot.mapper.LevelMapper;
import com.qianfeng.springboot.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelMapper levelMapper;
    @Override
    public List<Level> getLevelList() {

        List<Level> levelList = levelMapper.getLevelList();
        return levelList;
    }

    @Override
    public Level getLevel(Integer levelId) {

        Level level = levelMapper.getLevel(levelId);
        return level;
    }
}
