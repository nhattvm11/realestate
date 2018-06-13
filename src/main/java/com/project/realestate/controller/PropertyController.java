package com.project.realestate.controller;

import com.project.realestate.entity.PropertyType;
import com.project.realestate.entity.User;
import com.project.realestate.exception.PropertyTypeException;
import com.project.realestate.service.PropertyTypeService;
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
public class PropertyController {

    @Autowired
    UserService userService;

    @Autowired
    PropertyTypeService propertyTypeService;

    @GetMapping("/property/create")
    public ModelAndView createPropertyForm() {
        ModelAndView modelAndView = new ModelAndView("createProperty");
        PropertyType propertyType = new PropertyType();
        modelAndView.addObject("property", propertyType);
        modelAndView.addObject("role", getRole());
        return modelAndView;
    }

    @PostMapping("/property/create")
    public String handleCreateProperty(@ModelAttribute PropertyType propertyType) {
        propertyTypeService.save( null,propertyType);
        return "redirect:/admin/properties";
    }

    @GetMapping("/properties")
    public ModelAndView listProperty() throws PropertyTypeException {
        ModelAndView modelAndView = new ModelAndView("listProperty");
        List<PropertyType> propertyTypes = propertyTypeService.findAll();
        modelAndView.addObject("properties", propertyTypes);
        modelAndView.addObject("role", getRole());
        return modelAndView;
    }

    @GetMapping("property/update/{id}")
    public ModelAndView updateProperty(@PathVariable("id") String id) throws PropertyTypeException {
        ModelAndView modelAndView = new ModelAndView("updateProperty");
        modelAndView.addObject("property",propertyTypeService.findById(id));
        modelAndView.addObject("role", getRole());
        return modelAndView;
    }

    @PostMapping("property/update/{id}")
    public String HandleUpdateProperty(@PathVariable("id") String id, @ModelAttribute PropertyType propertyType, Model model){
        propertyTypeService.save(id, propertyType);
        model.addAttribute("role", getRole());
        return "redirect:/admin/properties";
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
