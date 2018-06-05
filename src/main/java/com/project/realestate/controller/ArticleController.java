package com.project.realestate.controller;

import com.project.realestate.Specification.ArticleSpecificationBuilder;
import com.project.realestate.entity.*;
import com.project.realestate.exception.ArticleException;
import com.project.realestate.exception.FeatureException;
import com.project.realestate.model.ArticleError;
import com.project.realestate.model.ArticleTemp;
import com.project.realestate.model.DistrictTemp;
import com.project.realestate.service.*;
import jdk.internal.org.xml.sax.SAXException;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
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

    @Autowired
    private TypeService typeService;

    @Autowired
    private PropertyTypeService propertyTypeService;

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

    @GetMapping(value = "/article/search")
    public String searchAricles(Model model, @RequestParam(required = false) String filter, @RequestParam(required=false) Map<String, String> searchTerm,@RequestParam(value = "page", defaultValue = "0") int page) {
        ArticleSpecificationBuilder builder = new ArticleSpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        String criteria  = "cityByCityId:"+searchTerm.get("city")+","
                + searchTerm.get("type")+','
                + searchTerm.get("property")+','
                + searchTerm.get("district")+','
                + searchTerm.get("direction")+','
                + searchTerm.get("area")+','
                + searchTerm.get("price")+','
                + searchTerm.get("bedroom")+','
                + searchTerm.get("bathroom")+','
                + searchTerm.get("tier");

        if (filter != null){
            criteria = criteria + ","+filter;
        }
        Matcher matcher = pattern.matcher(criteria + ',');
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
        model.addAttribute("pageInfo", searchResultPage.getTotalPages());
        model.addAttribute("data", articleService.parseListEntityToListModel(searchResultPage.getContent(), true));
        model.addAttribute("currentPage", page);
        return "listArticlePage";
    }

    @GetMapping("/article/detail/{id}")
    public String articleDetail(@PathVariable("id") String id, Model model) throws ArticleException, FeatureException, org.xml.sax.SAXException, ParserConfigurationException, SAXException, IOException {
        ArticleTemp articleTemp = articleService.convertArticleEntityToModel(id, true);
        model.addAttribute("article", articleTemp);
        model.addAttribute("features", articleService.getMapFeaturesOfArticle(id));
        model.addAttribute("coordinate", getCordinates(articleTemp.getAddress(), articleTemp.getCityId()));
        return "articleDetail";
    }

    public String[] getCordinates(String address,String county) throws IOException, ParserConfigurationException, SAXException, org.xml.sax.SAXException {
        String thisLine;
        String fullAddress = address.replace(" ", "%20")+",%20"+county.replace(" ", "%20");
        System.out.println(fullAddress);

        URL url = new URL("https://maps.googleapis.com/maps/api/geocode/xml?key=AIzaSyDEUhgpaRslz8IddVuYTz5miCWWTS_caiI&address="+fullAddress);

//        BufferedReader theHTML = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedReader theHTML = new BufferedReader(new InputStreamReader(((HttpURLConnection) url.openConnection()).getInputStream(), Charset.forName("UTF-8")));

        FileWriter fstream = new FileWriter("url.xml");
        BufferedWriter out = new BufferedWriter(fstream);
        while ((thisLine = theHTML.readLine()) != null)
            out.write(thisLine);
        out.close();

        File file = new File("url.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();

        NodeList n1 = doc.getElementsByTagName("status");
        Element n = (Element)n1.item(0);
        String st1 = n.getFirstChild().getNodeValue();
        String coordinate[] = new String[2];
        if (st1.equals("OK")){
            NodeList n2 = doc.getElementsByTagName("lat");
            Element nn = (Element)n2.item(0);
            String st2 = nn.getFirstChild().getNodeValue();
            NodeList n3 = doc.getElementsByTagName("lng");
            Element nnn= (Element)n3.item(0);
            String st3 = nnn.getFirstChild().getNodeValue();
            coordinate[0] = st2;
            coordinate[1] = st3;
        }
        return coordinate;
    }

    @GetMapping("/article/{category}")
    public String category(Model model, @RequestParam(required = false) String filter, @PathVariable("category") String category, @RequestParam(value = "page", defaultValue = "0") int page){
        category.replace('-', ' ');
        Page<Article> categories;
        try {
            String type = category.substring(0, 4);
            String property = category.substring(5);
            if (filter != null){
                ArticleSpecificationBuilder builder = new ArticleSpecificationBuilder();
                Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
                Matcher matcher = pattern.matcher(filter + ',');
                while (matcher.find()){
                    builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
                }
                builder.with("propertyTypeByPropertyId", ":", propertyTypeService.findByName(property));
                builder.with("typeByTypeId", ":", typeService.findTypeByName(type));
                Specification<Article> spec = builder.build();
                categories = articleService.findBySearchTerm(spec, page, 4);
            }else {
                categories = articleService.getCategory(type, property, page, 4);
            }

            model.addAttribute("data", articleService.parseListEntityToListModel(categories.getContent(), true));
            model.addAttribute("pageInfo", categories.getTotalPages());
            model.addAttribute("currentPage", page);
        }catch (Exception e){
            return "redirect:/home";
        }
        return "listArticlePage";
    }
}
