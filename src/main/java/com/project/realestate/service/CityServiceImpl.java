package com.project.realestate.service;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.City;
import com.project.realestate.exception.CityException;
import com.project.realestate.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAll() throws CityException {
        List<City> cities = cityRepository.findAll();
        if (cities.isEmpty())
            throw new CityException("no city found");
        return cities;
    }
}
