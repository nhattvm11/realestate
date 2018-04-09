package com.project.realestate.repository;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository  extends JpaRepository<City, String>{
    @Override
    List<City> findAll();
    City findCitiesById(String id);
}
