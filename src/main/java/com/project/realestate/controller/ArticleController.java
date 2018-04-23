package com.project.realestate.controller;

import com.project.realestate.Specification.ArticleSpecificationBuilder;
import com.project.realestate.entity.*;
import com.project.realestate.exception.ArticleException;
import com.project.realestate.model.ArticleError;
import com.project.realestate.model.ArticleTemp;
import com.project.realestate.model.DistrictTemp;
import com.project.realestate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private String UPLOAD_PATH = "C:\\Users\\Anh\\Desktop\\realestate\\src\\main\\resources\\static\\image\\";

    @GetMapping("/article/create")
    public ModelAndView createArticleView() throws Exception{
        ModelAndView model = new ModelAndView("createArticle");
        model.addObject("title", "Create Article");
        ArticleTemp articleTemp = new ArticleTemp();articleTemp.setCityId("-1");
        articleService.setModel(model);
        model.addObject("article", articleTemp);
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
            String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+ file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_PATH + fileName);
            Files.write(path, imageData);

            String imagePath = "/images/" + fileName;
            pictureService.saveImage(articleId, imagePath, false);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("article/update/{id}")
    public ModelAndView updateArticleView(@PathVariable("id")String id) throws Exception{
        ModelAndView model = new ModelAndView();
        model.setViewName("updateArticle");
        articleService.setModel(model);
        model.addObject("article", articleService.convertArticleEntityToModel(id, false));
        return model;
    }

    @PostMapping("/article/update/{id}")
    public ResponseEntity updateArticleHandler(@PathVariable("id") String id,@Valid @ModelAttribute("article") ArticleTemp articleTemp, BindingResult result) throws Exception {
        if(result.hasErrors()){
            ArticleError articleError = new ArticleError();
            articleService.initArticleError(articleError, result);
            return new ResponseEntity(articleError, HttpStatus.BAD_REQUEST);
        }
        articleService.updateArticle(id, articleTemp);
        return new ResponseEntity(HttpStatus.OK);
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

    @RequestMapping(value = "/article/search", method = RequestMethod.GET)
    public String searchAricles(Model model, @RequestParam("searchTerm") String searchTerm,@RequestParam(value = "page", defaultValue = "0") int page) {
        ArticleSpecificationBuilder builder = new ArticleSpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(searchTerm + ",");
        while (matcher.find()) {
            switch (matcher.group(1)){
                case "directionByDirectionId":
                    Direction direction = new Direction();
                    direction.setId(matcher.group(3));
                    builder.with(matcher.group(1), matcher.group(2), direction);
                    break;
                case "cityByCityId":
                    City city = new City();
                    city.setId(matcher.group(3));
                    builder.with(matcher.group(1), matcher.group(2), city);
                    break;
                case "districtByDistrictId":
                    District district = new District();
                    district.setId(matcher.group(3));
                    builder.with(matcher.group(1), matcher.group(2), district);
                    break;
                case "propertyTypeByPropertyId":
                    PropertyType propertyType = new PropertyType();
                    propertyType.setId(matcher.group(3));
                    builder.with(matcher.group(1), matcher.group(2), propertyType);
                    break;
                case "typeByTypeId":
                    Type type = new Type();
                    type.setId(matcher.group(3));
                    builder.with(matcher.group(1), matcher.group(2), type);
                    break;
                default:
                    builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
                    break;
            }
        }

        Specification<Article> spec = builder.build();
        Page<Article> searchResultPage = articleService.findBySearchTerm(spec, page, 4);
        model.addAttribute("pageInfo", searchResultPage);
        model.addAttribute("data", articleService.parseListEntityToListModel(searchResultPage.getContent(), true));
        model.addAttribute("currentPage", page);
        return "listArticlePage";
    }

    
}
