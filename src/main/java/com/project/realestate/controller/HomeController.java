package com.project.realestate.controller;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.User;
import com.project.realestate.exception.TypeException;
import com.project.realestate.service.ArticleService;
import com.project.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public ModelAndView listArticles(ModelAndView model) throws Exception {
        List<Article> saleArticles = articleService.getTop10Article(0, "1");
        List<Article> rentArticles = articleService.getTop10Article(0, "2");
        List<Article> normalArticles = articleService.getTop10ArticleByPriority(0);
        List<Article> sliderArticles = articleService.getSlider(0);
        articleService.setModel(model, true);
        model.setViewName("index");

        model.addObject("saleArticles", articleService.parseListEntityToListModel(saleArticles, true));
        model.addObject("rentArticles", articleService.parseListEntityToListModel(rentArticles, true));
        model.addObject("normalArticles", articleService.parseListEntityToListModel(normalArticles, true));
        model.addObject("sliderArticles", articleService.parseListEntityToListModel(sliderArticles, true));
        try{
            UserDetails userDetails = (UserDetails) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();
            User user = userService.getUSerByEmail(userDetails.getUsername());
            model.addObject("role", user.getLevelByLevelId().getLevelName());
        } catch (Exception e){
            model.addObject("role", "none");
        }
        return model;
    }
}
