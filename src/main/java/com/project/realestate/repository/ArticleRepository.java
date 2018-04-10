package com.project.realestate.repository;

import com.project.realestate.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {
    public Article findArticleById(String id);
}
