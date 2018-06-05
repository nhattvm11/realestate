package com.project.realestate.controller;

import com.project.realestate.entity.Feature;
import com.project.realestate.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @GetMapping("/feature/create")
    public ModelAndView createFeatureForm() {
        ModelAndView modelAndView = new ModelAndView("createFeature");
        Feature feature = new Feature();
        modelAndView.addObject("feature", feature);
        return modelAndView;
    }

    @PostMapping("/feature/create")
    public String handleCreateFeature(@ModelAttribute Feature feature) {
        featureService.save(feature);
        return "redirect:/features";
    }

    @GetMapping("/features")
    public ModelAndView listFeature() {
        ModelAndView modelAndView = new ModelAndView("listFeature");
        List<Feature> features = featureService.findAll();
        modelAndView.addObject("features", features);
        return modelAndView;
    }

    @GetMapping("/feature/delete/{id}")
    public String deleteFeature(@PathVariable("id") String id) {
        featureService.delete(id);
        return "redirect:/features";
    }

}
