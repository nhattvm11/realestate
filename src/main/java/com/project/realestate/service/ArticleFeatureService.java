package com.project.realestate.service;

import com.project.realestate.entity.ArticleFeature;
import com.project.realestate.exception.ArticleFeatureException;

public interface ArticleFeatureService {
    public void SaveArticleFeature(ArticleFeature articleFeature) throws ArticleFeatureException;
}
