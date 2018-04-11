package com.project.realestate.repository;

import com.project.realestate.entity.City;
import com.project.realestate.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, String> {
    List<District> findDistrictByCityByCitiId(City city);
    District findDistrictById(String id);
}
