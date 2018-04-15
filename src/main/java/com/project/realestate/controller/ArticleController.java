package com.project.realestate.controller;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.City;
import com.project.realestate.entity.District;
import com.project.realestate.exception.ArticleException;
import com.project.realestate.model.ArticleError;
import com.project.realestate.model.ArticleTemp;
import com.project.realestate.model.DistrictTemp;
import com.project.realestate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private PictureService pictureService;

    private String UPLOAD_PATH = "C:\\Users\\Anh\\Desktop\\realestate\\src\\main\\resources\\image\\";

    @GetMapping("/article/create")
    public ModelAndView createArticleView() throws Exception{
        ModelAndView model = new ModelAndView("createArticle");
        model.addObject("title", "Create Article");
        ArticleTemp articleTemp = new ArticleTemp();articleTemp.setCityId("-1");
        setModel(model, articleTemp);
        return model;
    }


    @PostMapping("/article/create")
    public ResponseEntity createArticleHandler(@Valid @ModelAttribute("article") ArticleTemp articleTemp, BindingResult result) throws Exception{
        if(result.hasErrors()){
            ArticleError articleError = new ArticleError();
            articleService.initArticleError(articleError, result);
            return new ResponseEntity(articleError, HttpStatus.BAD_REQUEST);
        }
        Article article = new Article();
        articleService.parseArticleTempToEntity(article, articleTemp);
        articleService.SaveArticle(article);

        articleFeatureService.SaveArticleFeature(articleTemp.getFeatures(), article.getId());
        return new ResponseEntity(article.getId(), HttpStatus.OK);
    }

    @PostMapping("/article/uploadImage/{articleId}")
    public ResponseEntity uploadDropzone(MultipartHttpServletRequest request, @PathVariable(value = "articleId") String articleId) throws IOException, ArticleException {
        Map<String, MultipartFile> fileMap = request.getFileMap();
        for (MultipartFile file : fileMap.values()) {
            byte[] imageData = file.getBytes();
            Path path = Paths.get(UPLOAD_PATH + new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+ file.getOriginalFilename());
            Files.write(path, imageData);

            String imagePath = "/images/" + file.getOriginalFilename();
            pictureService.saveImage(articleId, imagePath, false);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("article/update/{id}")
    public ModelAndView updateArticleView(@PathVariable("id")String id) throws Exception{
        ModelAndView model = new ModelAndView();
        model.setViewName("updateArticle");
        setModel(model, articleService.convertArticleEntityToModel(id));

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


    @GetMapping("/article/list")
    public String listArticles(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("data", articleService.findAllPagination(page, 4));
        model.addAttribute("currentPage", page);
        return "listArticle";
    }

    private void setModel(ModelAndView model, ArticleTemp articleTemp) throws Exception {
        model.addObject("cities", articleService.initCityModel());
        model.addObject("types", articleService.initTypeModel());
        model.addObject("propertyTypes", articleService.initPropertyTypeModel());
        model.addObject("features", articleService.initFeatureModel());
        model.addObject("directions", articleService.initDirectionModel());

        model.addObject("article", articleTemp);
    }
}
