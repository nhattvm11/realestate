package com.project.realestate.controller;

import com.project.realestate.entity.Feature;
import com.project.realestate.entity.User;
import com.project.realestate.service.FeatureService;
import com.project.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/")
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @Autowired
    UserService userService;

    @GetMapping("/feature/create")
    public ModelAndView createFeatureForm() {
        ModelAndView modelAndView = new ModelAndView("createFeature");
        Feature feature = new Feature();
        modelAndView.addObject("feature", feature);
        modelAndView.addObject("role", getRole());
        return modelAndView;
    }

    @PostMapping("/feature/create")
    public String handleCreateFeature(@ModelAttribute Feature feature) {
        featureService.save(null, feature);
        return "redirect:/admin/features";
    }

    @GetMapping("/features")
    public ModelAndView listFeature() {
        ModelAndView modelAndView = new ModelAndView("listFeature");
        List<Feature> features = featureService.findAll();
        modelAndView.addObject("features", features);
        modelAndView.addObject("role", getRole());
        return modelAndView;
    }

    @GetMapping("/feature/update/{id}")
    public ModelAndView deleteFeature(@PathVariable("id") String id) {
        ModelAndView model = new ModelAndView("updateFeature");
        Feature feature = featureService.findById(id);
        model.addObject("feature", feature);
        model.addObject("role", getRole());
        return model;
    }

    @PostMapping("/feature/update/{id}")
    public String deleteFeature(@PathVariable("id") String id, @ModelAttribute Feature feature, Model model) {
        featureService.save(id, feature);
        model.addAttribute("role", getRole());
        return "redirect:/admin/features";
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
