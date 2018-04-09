package com.project.realestate.service;

import com.project.realestate.entity.ArticleFeature;
import com.project.realestate.exception.ArticleFeatureException;
import com.project.realestate.repository.ArticleFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleFeatureServiceImpl implements ArticleFeatureService{

    @Autowired
    private ArticleFeatureRepository articleFeatureRepository;

    @Override
    public void SaveArticleFeature(ArticleFeature articleFeature) throws ArticleFeatureException {
        articleFeatureRepository.save(articleFeature);
    }
}
