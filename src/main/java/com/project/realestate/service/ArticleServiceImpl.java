package com.project.realestate.service;

import com.project.realestate.entity.*;
import com.project.realestate.exception.*;
import com.project.realestate.model.ArticleTemp;
import com.project.realestate.model.DistrictTemp;
import com.project.realestate.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CityService cityService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private PropertyTypeService propertyTypeService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private DirectionSerVice directionSerVice;

    @Autowired
    private ArticleFeatureService articleFeatureService;

    @Override
    public void SaveArticle(Article article) {
        if (article != null)
            articleRepository.save(article);
    }

    @Override
    public Article findById(String id) throws ArticleException {
        Article article = articleRepository.findArticleById(id);
        if (article == null)
            throw new ArticleException("article not found");
        return article;
    }

    @Override
    public void convertDistrictEntityToDistrictTemp(List<District> districts, List<DistrictTemp> districtTemps) {
        for (District district:districts) {
            DistrictTemp temp = new DistrictTemp();
            temp.setId(district.getId());
            temp.setDistrictName(district.getDistrictName());
            districtTemps.add(temp);
        }
    }

    @Override
    public void parseArticleTempToEntity(Article article, ArticleTemp articleTemp) throws Exception {
        if(article.getId() == null){
            article.setId(UUID.randomUUID().toString());
        }
        article.setActive(false);
        article.setAddress(articleTemp.getAddress());
        article.setAreasize(articleTemp.getAreasize());
        article.setBathroom(articleTemp.getBathroom());
        article.setBedroom(articleTemp.getBedroom());
        article.setTier(articleTemp.getTier());
        article.setTitle(articleTemp.getTitle());
        article.setPrice(articleTemp.getPrice());
        article.setLivingroom(articleTemp.getLivingroom());
        article.setDescription(articleTemp.getDescription());
        article.setPriority(0);
        article.setView(0);


        City city = cityService.findById(articleTemp.getCityId());
        District district = districtService.findById(articleTemp.getDistrictId());
        Type type = typeService.findById(articleTemp.getTypeId());
        PropertyType propertyType = propertyTypeService.findById(articleTemp.getPropertyId());
        Direction direction = directionSerVice.findById(articleTemp.getDirectionId());

        article.setCityByCityId(city);
        article.setDistrictByDistrictId(district);
        article.setTypeByTypeId(type);
        article.setPropertyTypeByPropertyId(propertyType);
        article.setDirectionByDirectionId(direction);
    }

    public void convertDirectionListToMap(List<Direction> directions, Map<String, String> directionMap) {
        for (Direction direction: directions) {
            directionMap.put(direction.getId(), direction.getDirectionName());
        }
    }

    public void convertFeatureListToMap(List<Feature> features, Map<String, String> featureMap) {
        for (Feature feature: features) {
            featureMap.put(feature.getId(), feature.getFeatureName());
        }
    }

    public void convertPropertyTypeListToMap(List<PropertyType> propertyTypes, Map<String, String> propertyTypeMap) {
        for (PropertyType type: propertyTypes) {
            propertyTypeMap.put(type.getId(), type.getPropertyName());
        }
    }

    public void convertTypeListToMap(List<Type> types, Map<String, String> typesMap) {
        for (Type type: types) {
            typesMap.put(type.getId(), type.getTypeName());
        }
    }

    public void convertCityListToMap(List<City> cities, Map<String, String> citiesMap) {
        citiesMap.put("-1", "--Select City--");
        for (City city: cities) {
            citiesMap.put(city.getId(), city.getCityName());
        }
    }

    @Override
    public Map<String, String> initCityModel() throws CityException {
        List<City> cities = cityService.findAll();
        Map<String, String> citiesMap = new HashMap<>();
        convertCityListToMap(cities, citiesMap);
        return citiesMap;
    }

    @Override
    public Map<String, String> initTypeModel() throws TypeException {
        List<Type> types = typeService.findAll();
        Map<String, String> typesMap = new HashMap<>();
        convertTypeListToMap(types, typesMap);
        return typesMap;
    }

    @Override
    public Map<String, String> initPropertyTypeModel() throws PropertyTypeException {
        List<PropertyType> propertyTypes = propertyTypeService.findAll();
        Map<String, String> propertyTypeMap = new HashMap<>();
        convertPropertyTypeListToMap(propertyTypes, propertyTypeMap);
        return propertyTypeMap;
    }

    @Override
    public Map<String, String> initFeatureModel() throws FeatureException {
        List<Feature> features = featureService.findAll();
        Map<String, String> featureMap = new HashMap<>();
        convertFeatureListToMap(features, featureMap);
        return featureMap;
    }

    @Override
    public Map<String, String> initDirectionModel() throws DirectionException {
        List<Direction> directions = directionSerVice.findAll();
        Map<String, String> directionMap = new HashMap<>();
        convertDirectionListToMap(directions, directionMap);
        return directionMap;
    }

    @Override
    public ArticleTemp convertArticleEntityToModel(String id) {
        Article article = articleRepository.findArticleById(id);
        ArticleTemp articleTemp = new ArticleTemp();

        parseArticleEntityToModel(article, articleTemp);
        return articleTemp;
    }

    @Override
    public void updateArticle(String id, ArticleTemp articleTemp) throws Exception {
        Article article = articleRepository.findArticleById(id);
        parseArticleTempToEntity(article, articleTemp);
        articleRepository.save(article);

        articleFeatureService.SaveArticleFeature(articleTemp.getFeatures(), id);
    }

    private void parseArticleEntityToModel(Article article, ArticleTemp articleTemp) {
        articleTemp.setId(article.getId());
        articleTemp.setActive(false);
        articleTemp.setAddress(article.getAddress());
        articleTemp.setAreasize(article.getAreasize());
        articleTemp.setBathroom(article.getBathroom());
        articleTemp.setBedroom(article.getBedroom());
        articleTemp.setTier(article.getTier());
        articleTemp.setTitle(article.getTitle());
        articleTemp.setPrice(article.getPrice());
        articleTemp.setLivingroom(article.getLivingroom());
        articleTemp.setDescription(article.getDescription());
        articleTemp.setPriority(0);
        articleTemp.setView(0);

        articleTemp.setCityId(article.getCityByCityId().getId());
        articleTemp.setDistrictId(article.getDistrictByDistrictId().getId());
        articleTemp.setTypeId(article.getTypeByTypeId().getId());
        articleTemp.setPropertyId(article.getPropertyTypeByPropertyId().getId());
        articleTemp.setDirectionId(article.getDirectionByDirectionId().getId());

        List<ArticleFeature> articleFeatures = articleFeatureService.findArticleFeatureByArticle(article);
        List<String> features = new ArrayList<>();
        if (!articleFeatures.isEmpty()){
            for (ArticleFeature articleFeature : articleFeatures) {
                features.add(articleFeature.getFeatureByFeatureId().getId());
            }
        }
        articleTemp.setFeatures(features);
    }
}
