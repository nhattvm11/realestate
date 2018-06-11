package com.project.realestate.service;

import com.project.realestate.entity.Level;
import com.project.realestate.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelRepository levelRepository;

    @Override
    public List<Level> findAll() {
        return levelRepository.findAll();
    }
}
