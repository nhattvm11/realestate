package com.project.realestate.controller;

import com.project.realestate.entity.*;
import com.project.realestate.model.ArticleTemp;
import com.project.realestate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    private CityService cityService;

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

    @GetMapping("/article/create")
    public ModelAndView createArticle() throws Exception{
        ModelAndView model = new ModelAndView();
        model.setViewName("createArticle");

        List<City> cities = cityService.findAll();
        Map<String, String> citiesMap = new HashMap<>();
        convertCityListToMap(cities, citiesMap);

        List<Type> types = typeService.findAll();
        Map<String, String> typesMap = new HashMap<>();
        convertTypeListToMap(types, typesMap);

        List<PropertyType> propertyTypes = propertyTypeService.findAll();
        Map<String, String> propertyTypeMap = new HashMap<>();
        convertPropertyTypeListToMap(propertyTypes, propertyTypeMap);

        List<Feature> features = featureService.findAll();
        Map<String, String> featureMap = new HashMap<>();
        convertFeatureListToMap(features, featureMap);

        List<Direction> directions = directionSerVice.findAll();
        Map<String, String> directionMap = new HashMap<>();
        convertDirectionListToMap(directions, directionMap);

        model.addObject("cities", citiesMap);
        model.addObject("types", typesMap);
        model.addObject("propertyTypes", propertyTypeMap);
        model.addObject("features", featureMap);
        model.addObject("directions", directionMap);

        model.addObject("article", new ArticleTemp());

        return model;
    }

    private void convertDirectionListToMap(List<Direction> directions, Map<String, String> directionMap) {
        for (Direction direction: directions) {
            directionMap.put(direction.getId(), direction.getDirectionName());
        }
    }

    private void convertFeatureListToMap(List<Feature> features, Map<String, String> featureMap) {
        for (Feature feature: features) {
            featureMap.put(feature.getId(), feature.getFeatureName());
        }
    }

    private void convertPropertyTypeListToMap(List<PropertyType> propertyTypes, Map<String, String> propertyTypeMap) {
        for (PropertyType type: propertyTypes) {
            propertyTypeMap.put(type.getId(), type.getPropertyName());
        }
    }

    private void convertTypeListToMap(List<Type> types, Map<String, String> typesMap) {
        for (Type type: types) {
            typesMap.put(type.getId(), type.getTypeName());
        }
    }

    private void convertCityListToMap(List<City> cities, Map<String, String> citiesMap){
        for (City city: cities) {
            citiesMap.put(city.getId(), city.getCityName());
        }
    }
}
