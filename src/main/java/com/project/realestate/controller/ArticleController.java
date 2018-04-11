package com.project.realestate.controller;

import com.project.realestate.entity.*;
import com.project.realestate.exception.CityException;
import com.project.realestate.model.ArticleError;
import com.project.realestate.model.ArticleTemp;
import com.project.realestate.model.DistrictTemp;
import com.project.realestate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private ArticleFeatureService articleFeatureService;

    @GetMapping("/article/create")
    public ModelAndView createArticleView() throws Exception{
        ModelAndView model = new ModelAndView("createArticle");
        setModel(model);
        return model;
    }


    @PostMapping("/article/create")
    public ModelAndView createArticleHandler(@Valid @ModelAttribute("article") ArticleTemp articleTemp, BindingResult result) throws Exception{
        if(result.hasErrors()){
            ModelAndView model = new ModelAndView("createArticle");
            setModel(model);
            ArticleError articleError = new ArticleError();
            articleService.initArticleError(articleError, result);
            model.addObject("errors", articleError);
            return model;
        }
        Article article = new Article();
        articleService.parseArticleTempToEntity(article, articleTemp);
        articleService.SaveArticle(article);

        articleFeatureService.SaveArticleFeature(articleTemp.getFeatures(), article.getId());
        return new ModelAndView("listArticle");
    }

    @GetMapping("article/update/{id}")
    public ModelAndView updateArticleView(@PathVariable("id")String id) throws Exception{
        ModelAndView model = new ModelAndView();
        model.setViewName("updateArticle");

        model.addObject("cities", articleService.initCityModel());
        model.addObject("types", articleService.initTypeModel());
        model.addObject("propertyTypes", articleService.initPropertyTypeModel());
        model.addObject("features", articleService.initFeatureModel());
        model.addObject("directions", articleService.initDirectionModel());

        model.addObject("article", articleService.convertArticleEntityToModel(id));

        return model;
    }

    @PostMapping("/article/update/{id}")
    public String updateArticleHandler(@PathVariable("id") String id,@Valid @ModelAttribute("article") ArticleTemp articleTemp) throws Exception {
        articleService.updateArticle(id, articleTemp);
        return "listArticle";
    }

    @GetMapping("/article/delete/{id}")
    public String deleteArticleHandler(@PathVariable("id") String id){
        articleService.deleteArticle(id);
        return "listArticle";
    }

    @PostMapping("/article/districts")
    public ResponseEntity<List<DistrictTemp>> getDistricts(@RequestParam(value = "cityId", required = false) String cityId) throws Exception {
        City city = cityService.findById(cityId);
        List<District> districts = districtService.findDistrictByCityId(city);
        List<DistrictTemp> districtTemps = new ArrayList<>();
        articleService.convertDistrictEntityToDistrictTemp(districts, districtTemps);

        return new ResponseEntity<List<DistrictTemp>>(districtTemps, HttpStatus.OK);
    }

    private void setModel(ModelAndView model) throws Exception {
        model.addObject("cities", articleService.initCityModel());
        model.addObject("types", articleService.initTypeModel());
        model.addObject("propertyTypes", articleService.initPropertyTypeModel());
        model.addObject("features", articleService.initFeatureModel());
        model.addObject("directions", articleService.initDirectionModel());

        ArticleTemp articleTemp = new ArticleTemp();
        articleTemp.setCityId("-1");
        model.addObject("article", articleTemp);
    }
}
