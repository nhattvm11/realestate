package com.project.realestate.service;

import com.project.realestate.Specification.ArticleSpecification;
import com.project.realestate.entity.*;
import com.project.realestate.exception.*;
import com.project.realestate.model.*;
import com.project.realestate.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

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
    public ArticleTemp convertArticleEntityToModel(String id, boolean info) {
        Article article = articleRepository.findArticleById(id);
        ArticleTemp articleTemp = new ArticleTemp();

        parseArticleEntityToModel(article, articleTemp, info);
        return articleTemp;
    }

    @Override
    public void setModel(ModelAndView model) throws Exception {
        model.addObject("cities", initCityModel());
        model.addObject("types", initTypeModel());
        model.addObject("propertyTypes", initPropertyTypeModel());
        model.addObject("features", initFeatureModel());
        model.addObject("directions", initDirectionModel());
    }

    @Override
    public void updateArticle(String id, ArticleTemp articleTemp) throws Exception {
        Article article = articleRepository.findArticleById(id);
        parseArticleTempToEntity(article, articleTemp);
        articleRepository.save(article);

        articleFeatureService.SaveArticleFeature(articleTemp.getFeatures(), id);
    }

    @Override
    public void deleteArticle(String id) {
        Article article = articleRepository.findArticleById(id);
        List<ArticleFeature> articleFeatures = articleFeatureService.findArticleFeatureByArticle(article);

        List<String> featureId = new ArrayList<>();
        if (!articleFeatures.isEmpty()){
            for (ArticleFeature articleFeature:articleFeatures) {
                articleFeatureService.deleteArticleFeature(articleFeature);
            }
        }

        articleRepository.delete(article);
    }

    @Override
    public void initArticleError(ArticleError articleError, BindingResult result) {
        if (result.getFieldError("address") != null){
            articleError.setAddress(result.getFieldError("address").getDefaultMessage());
        }
        if (result.getFieldError("title") != null){
            articleError.setTier(result.getFieldError("title").getDefaultMessage());
        }
        if (result.getFieldError("areasize") != null){
            articleError.setAreasize(result.getFieldError("areasize").getDefaultMessage());
        }
        if (result.getFieldError("bedroom") != null){
            articleError.setBedroom(result.getFieldError("bedroom").getDefaultMessage());
        }
        if (result.getFieldError("bathroom") != null){
            articleError.setBathroom(result.getFieldError("bathroom").getDefaultMessage());
        }
        if (result.getFieldError("livingroom") != null){
            articleError.setLivingroom(result.getFieldError("livingroom").getDefaultMessage());
        }
        if (result.getFieldError("tier") != null){
            articleError.setTier(result.getFieldError("tier").getDefaultMessage());
        }
        if (result.getFieldError("price") != null){
            articleError.setPrice(result.getFieldError("price").getDefaultMessage());
        }
        if (result.getFieldError("description") != null){
            articleError.setDescription(result.getFieldError("description").getDefaultMessage());
        }
        if (result.getFieldError("typeId") != null){
            articleError.setTypeId(result.getFieldError("typeId").getDefaultMessage());
        }
        if (result.getFieldError("propertyId") != null){
            articleError.setPropertyId(result.getFieldError("propertyId").getDefaultMessage());
        }
        if (result.getFieldError("cityId") != null){
            articleError.setCityId(result.getFieldError("cityId").getDefaultMessage());
        }
        if (result.getFieldError("districtId") != null){
            articleError.setDistrictId(result.getFieldError("districtId").getDefaultMessage());
        }
        if (result.getFieldError("directionId") != null){
            articleError.setDirectionId(result.getFieldError("directionId").getDefaultMessage());
        }
    }

    @Override
    public Page<Article> findAllPagination(int page, int pagesize) {
        return articleRepository.findAll(PageRequest.of(page, pagesize));
    }

    @Override
    public Page<Article> findBySearchTerm(Specification specification, int page, int size) {
        Page<Article> searchResultPage = articleRepository.findAll(specification, PageRequest.of(page, size));
        return searchResultPage;
    }

    @Override
    public List<Article> getTop10Article(int priority, String typeId) throws TypeException {
        Type type = typeService.findById(typeId);
        return articleRepository.findTop10ByPriorityAndTypeByTypeId(priority, type);
    }

    @Override
    public List<Article> getTop10ArticleByPriority(int priority) {
        return articleRepository.findTop10ByPriority(priority);
    }

    @Override
    public List<Article> getSlider(int priority) {
        return articleRepository.findTop3ByPriority(priority);
    }

    @Override
    public List<ArticleTemp> parseListEntityToListModel(List<Article> articles, boolean info) {
        List<ArticleTemp> articleTemps = new ArrayList<>();
        for (Article article:articles) {
            ArticleTemp articleTemp = new ArticleTemp();
            parseArticleEntityToModel(article, articleTemp, info);
            articleTemps.add(articleTemp);
        }
        return articleTemps;
    }

    private void parseArticleEntityToModel(Article article, ArticleTemp articleTemp, boolean info) {
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

        if (info){
            articleTemp.setCityId(article.getCityByCityId().getCityName());
            articleTemp.setDistrictId(article.getDistrictByDistrictId().getDistrictName());
            articleTemp.setTypeId(article.getTypeByTypeId().getTypeName());
            articleTemp.setPropertyId(article.getPropertyTypeByPropertyId().getPropertyName());
            articleTemp.setDirectionId(article.getDirectionByDirectionId().getDirectionName());
        }else{
            articleTemp.setCityId(article.getCityByCityId().getId());
            articleTemp.setDistrictId(article.getDistrictByDistrictId().getId());
            articleTemp.setTypeId(article.getTypeByTypeId().getId());
            articleTemp.setPropertyId(article.getPropertyTypeByPropertyId().getId());
            articleTemp.setDirectionId(article.getDirectionByDirectionId().getId());
        }

        List<ArticleFeature> articleFeatures = articleFeatureService.findArticleFeatureByArticle(article);
        List<String> features = new ArrayList<>();
        if (!articleFeatures.isEmpty()){
            for (ArticleFeature articleFeature : articleFeatures) {
                features.add(articleFeature.getFeatureByFeatureId().getId());
            }
        }
        articleTemp.setFeatures(features);

        if (!article.getPicturesById().isEmpty()){
            List<Picture> pictures = new ArrayList<>(article.getPicturesById());
            List<PictureTemp> pictureTemps = new ArrayList<>();

            for (Picture picture:pictures) {
                if(picture.getThumbnail()){
                    articleTemp.setThumbnail(picture.getUrl());
                }
                PictureTemp pictureTemp = new PictureTemp();
                pictureTemp.setId(picture.getId());
                pictureTemp.setUrl(picture.getUrl());
                pictureTemps.add(pictureTemp);
            }
            articleTemp.setPictures(pictureTemps);
        }
    }
}
