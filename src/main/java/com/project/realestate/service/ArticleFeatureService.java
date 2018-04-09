package com.project.realestate.service;

import com.project.realestate.entity.ArticleFeature;
import com.project.realestate.exception.ArticleException;
import com.project.realestate.exception.ArticleFeatureException;
import com.project.realestate.exception.FeatureException;

import java.util.List;

public interface ArticleFeatureService {
    public void SaveArticleFeature(List<String> featureId, String articleId) throws ArticleFeatureException, ArticleException, FeatureException;
}
