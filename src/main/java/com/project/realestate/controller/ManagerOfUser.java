package com.project.realestate.controller;

import com.project.realestate.entity.User;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.service.ArticleService;
import com.project.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerOfUser {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @GetMapping("article/update/{id}")
    public ModelAndView updateArticleView(@PathVariable("id")String id) throws Exception{
        ModelAndView model = new ModelAndView();
        if (articleService.checkValidArticleMatchUser(id)){
            model.setViewName("updateArticle");
            articleService.setModel(model, false);
            model.addObject("article", articleService.convertArticleEntityToModel(id, false));
        }else {
            model.setViewName("error-401");
        }
        model.addObject("role", getRole());
        return model;
    }

    @GetMapping("/article/delete/{id}")
    public String deleteArticleHandler(@PathVariable("id") String id, Model model){
        articleService.deleteArticle(id);
        model.addAttribute("role", getRole());
        return "listArticle";
    }

    @GetMapping("/article/list")
    public String listArticles(Model model, @RequestParam(defaultValue = "0") int page) throws UserNotFoundException {
        model.addAttribute("data", articleService.findArticleByUserByUserId(page, 4));
        model.addAttribute("currentPage", page);
        model.addAttribute("role", getRole());
        return "listArticle";
    }

    @PostMapping("/article/delete/{id}")
    public ResponseEntity deleteArticleHandler(@PathVariable("id") String id){
        if (articleService.checkValidArticleMatchUser(id)){
            articleService.deleteArticle(id);
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    private String getRole(){
        try{
            UserDetails userDetails = (UserDetails) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();
            User user = userService.getUSerByEmail(userDetails.getUsername());
            return user.getLevelByLevelId().getLevelName();
        } catch (Exception e){
            return "none";
        }
    }
}
