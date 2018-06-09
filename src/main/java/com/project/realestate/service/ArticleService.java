package com.project.realestate.service;

import com.project.realestate.entity.*;
import com.project.realestate.exception.*;
import com.project.realestate.model.ArticleError;
import com.project.realestate.model.ArticleTemp;
import com.project.realestate.model.DistrictTemp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    void SaveArticle(Article article) throws ArticleException;
    Article findById(String id) throws ArticleException;
    void convertDistrictEntityToDistrictTemp(List<District> districts, List<DistrictTemp> districtTemps);
    void parseArticleTempToEntity(Article article, ArticleTemp articleTemp) throws Exception;
    Map<String, String> initCityModel() throws CityException;
    Map<String, String> initTypeModel() throws TypeException;
    Map<String, String> initPropertyTypeModel() throws PropertyTypeException;
    Map<String, String> initFeatureModel() throws FeatureException;
    Map<String, String> initDirectionModel() throws DirectionException;

    ArticleTemp convertArticleEntityToModel(String id, boolean info);
    void setModel(ModelAndView model) throws Exception;

    void updateArticle(String id, ArticleTemp articleTemp) throws Exception;

    void deleteArticle(String id);

    void initArticleError(ArticleError articleError, BindingResult result);
    Page<Article> findAllPagination(int page, int pagesize);
    Page<Article> findBySearchTerm(Specification specification, int page, int size);
    List<Article> getTop10Article(int priority, String typeId) throws TypeException;
    List<Article> getTop10ArticleByPriority(int priority);
    List<Article> getSlider(int priority);

    List<ArticleTemp> parseListEntityToListModel(List<Article> articles, boolean info);
    Map<String, Boolean> getMapFeaturesOfArticle(String articleId) throws ArticleException, FeatureException;
    Page<Article> getCategory(String type, String property, int page, int pageSize) throws TypeException, PropertyTypeException;
    List<ArticleTemp> getConfirmArticles(boolean isActive);
    boolean activeArticle(String articleId);

    Page<Article> getActiveArticles(int page, int pageSize);
}
