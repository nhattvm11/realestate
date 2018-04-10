package com.project.realestate.service;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.ArticleFeature;
import com.project.realestate.entity.Feature;
import com.project.realestate.exception.ArticleException;
import com.project.realestate.exception.ArticleFeatureException;
import com.project.realestate.exception.FeatureException;
import com.project.realestate.repository.ArticleFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArticleFeatureServiceImpl implements ArticleFeatureService{

    @Autowired
    private ArticleFeatureRepository articleFeatureRepository;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private FeatureService featureService;

    @Override
    public void SaveArticleFeature(List<String> featureId, String articleId) throws ArticleFeatureException, ArticleException, FeatureException {
        Article article = articleService.findById(articleId);
        List<ArticleFeature> articleFeatures = findArticleFeatureByArticle(article);

        if (!articleFeatures.isEmpty()){
            for (ArticleFeature articleFeature : articleFeatures) {
                articleFeatureRepository.delete(articleFeature);
            }
        }

        for (String feature: featureId) {
            ArticleFeature articleFeature = new ArticleFeature();
            articleFeature.setId(UUID.randomUUID().toString());
            articleFeature.setArticleByArticleId(article);

            Feature ft = featureService.findById(feature);
            articleFeature.setFeatureByFeatureId(ft);
            articleFeatureRepository.save(articleFeature);
        }
    }

    @Override
    public List<ArticleFeature> findArticleFeatureByArticle(Article article) {
        return articleFeatureRepository.findArticleFeatureByArticleByArticleId(article);
    }
}
