package com.project.realestate.service;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.City;
import com.project.realestate.exception.CityException;

import java.util.List;

public interface CityService {
    List<City> findAll() throws CityException;
}
