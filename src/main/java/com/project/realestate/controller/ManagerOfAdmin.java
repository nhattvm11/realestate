package com.project.realestate.controller;

import com.project.realestate.model.ArticleTemp;
import com.project.realestate.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/")
public class ManagerOfAdmin {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/create")
    public ModelAndView createArticleView() throws Exception{
        ModelAndView model = new ModelAndView("createArticle");
        model.addObject("title", "Create Article");
        ArticleTemp articleTemp = new ArticleTemp();articleTemp.setCityId("-1");
        articleService.setModel(model, false);
        model.addObject("article", articleTemp);
        return model;
    }

    @GetMapping("article/update/{id}")
    public ModelAndView updateArticleView(@PathVariable("id")String id) throws Exception{
        ModelAndView model = new ModelAndView();
        model.setViewName("updateArticle");
        articleService.setModel(model, false);
        model.addObject("article", articleService.convertArticleEntityToModel(id, false));
        return model;
    }

    @GetMapping("/article/delete/{id}")
    public String deleteArticleHandler(@PathVariable("id") String id){
        articleService.deleteArticle(id);
        return "listArticle";
    }

    @GetMapping("/article/list")
    public String listArticles(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("data", articleService.findAllPagination(page, 4));
        model.addAttribute("currentPage", page);
        return "listArticle";
    }

    @GetMapping("/article/activeArticles")
    public String activeArticlePage(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("data", articleService.getActiveArticles(page, 4));
        model.addAttribute("currentPage", page);
        return "confirmArticles";
    }

    @PostMapping("/article/confirmArts")
    public ResponseEntity<List<ArticleTemp>> getConfirmArticles(){
        List<ArticleTemp> confirmArticles = articleService.getConfirmArticles(false);
        if (confirmArticles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(confirmArticles, HttpStatus.OK);
    }

    @PostMapping("/article/activeArticle")
    public ResponseEntity activeArticle(@RequestParam("id") String articleId){
        if (articleService.activeArticle(articleId))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
