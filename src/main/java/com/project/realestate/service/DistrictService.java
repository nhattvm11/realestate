package com.project.realestate.service;

import com.project.realestate.entity.City;
import com.project.realestate.entity.District;
import com.project.realestate.exception.DistrictException;

import java.util.List;

public interface DistrictService {
    public List<District> findDistrictByCityId(City city) throws DistrictException;
    District findById(String id) throws DistrictException;
}
