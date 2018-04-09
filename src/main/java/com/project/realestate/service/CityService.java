package com.project.realestate.service;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.City;
import com.project.realestate.exception.CityException;

import java.util.List;

public interface CityService {
    public List<City> findAll() throws CityException;
    public City findById(String id) throws CityException;
}
