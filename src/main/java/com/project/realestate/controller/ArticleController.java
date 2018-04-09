package com.project.realestate.controller;

import com.project.realestate.entity.*;
import com.project.realestate.model.ArticleTemp;
import com.project.realestate.model.DistrictTemp;
import com.project.realestate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class


ArticleController {

    @Autowired
    private ArticleService articleService;


    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private ArticleFeatureService articleFeatureService;

    @GetMapping("/article/create")
    public ModelAndView createArticleView() throws Exception{
        ModelAndView model = new ModelAndView();
        model.setViewName("createArticle");

        model.addObject("cities", articleService.initCityModel());
        model.addObject("types", articleService.initTypeModel());
        model.addObject("propertyTypes", articleService.initPropertyTypeModel());
        model.addObject("features", articleService.initFeatureModel());
        model.addObject("directions", articleService.initDirectionModel());

        model.addObject("article", new ArticleTemp());

        return model;
    }


    @PostMapping("/article/create")
    public String createArticleHandler(@ModelAttribute("article") ArticleTemp articleTemp) throws Exception{
        Article article = new Article();
        articleService.parseArticleTempToEntity(article, articleTemp);
        articleService.SaveArticle(article);

        articleFeatureService.SaveArticleFeature(articleTemp.getFeatures(), article.getId());
        return "listArticle";
    }

    @GetMapping("/article/districts")
    public ResponseEntity<List<DistrictTemp>> getDistricts(@RequestParam(value = "cityId", required = false) String cityId) throws Exception {
        City city = cityService.findById(cityId);
        List<District> districts = districtService.findDistrictByCityId(city);
        List<DistrictTemp> districtTemps = new ArrayList<>();
        articleService.convertDistrictEntityToDistrictTemp(districts, districtTemps);

        return new ResponseEntity<List<DistrictTemp>>(districtTemps, HttpStatus.OK);
    }
}
