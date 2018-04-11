package com.project.realestate.service;

import com.project.realestate.entity.*;
import com.project.realestate.exception.*;
import com.project.realestate.model.ArticleError;
import com.project.realestate.model.ArticleTemp;
import com.project.realestate.model.DistrictTemp;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    public void SaveArticle(Article article) throws ArticleException;
    public Article findById(String id) throws ArticleException;
    public void convertDistrictEntityToDistrictTemp(List<District> districts, List<DistrictTemp> districtTemps);
    public void parseArticleTempToEntity(Article article, ArticleTemp articleTemp) throws Exception;
    public Map<String, String> initCityModel() throws CityException;
    public Map<String, String> initTypeModel() throws TypeException;
    public Map<String, String> initPropertyTypeModel() throws PropertyTypeException;
    public Map<String, String> initFeatureModel() throws FeatureException;
    public Map<String, String> initDirectionModel() throws DirectionException;

    ArticleTemp convertArticleEntityToModel(String id);

    void updateArticle(String id, ArticleTemp articleTemp) throws Exception;

    void deleteArticle(String id);

    void initArticleError(ArticleError articleError, BindingResult result);
}
