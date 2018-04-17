package com.project.realestate.repository;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.ArticleFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ArticleFeatureRepository extends JpaRepository<ArticleFeature, String>, JpaSpecificationExecutor<Article> {
    public List<ArticleFeature> findArticleFeatureByArticleByArticleId(Article article);
}
