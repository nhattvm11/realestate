package com.project.realestate.repository;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.ArticleFeature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleFeatureRepository extends JpaRepository<ArticleFeature, String> {
    public List<ArticleFeature> findArticleFeatureByArticleByArticleId(Article article);
}
