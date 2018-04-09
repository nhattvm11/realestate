package com.project.realestate.service;

import com.project.realestate.entity.District;
import com.project.realestate.exception.DistrictException;

import java.util.List;

public interface DistrictService {
    public List<District> findDistrictByCityId(String cityId) throws DistrictException;
}
