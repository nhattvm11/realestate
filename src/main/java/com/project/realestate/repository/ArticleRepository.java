package com.project.realestate.repository;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.PropertyType;
import com.project.realestate.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, String>,JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {
    Article findArticleById(String id);
    List<Article> findTop10ByPriorityAndTypeByTypeId(int priority, Type type);
    List<Article> findTop10ByPriority(int priority);
    List<Article> findTop3ByPriority(int priority);
}
