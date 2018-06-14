package com.project.realestate.service;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.ArticleFeature;
import com.project.realestate.entity.Feature;
import com.project.realestate.exception.ArticleException;
import com.project.realestate.exception.ArticleFeatureException;
import com.project.realestate.exception.FeatureException;

import java.util.List;

public interface ArticleFeatureService {
    void SaveArticleFeature(List<String> featureId, String articleId) throws ArticleFeatureException, ArticleException, FeatureException;
    List<ArticleFeature> findArticleFeatureByArticle(Article article);
    void deleteArticleFeature(ArticleFeature articleFeature);
    List<ArticleFeature> findArticleFeatureBYFeature(Feature feature);
}
