package com.project.realestate.service;

import com.project.realestate.entity.District;
import com.project.realestate.exception.DistrictException;
import com.project.realestate.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<District> findDistrictByCityId(String cityId) throws DistrictException {
        List<District> districts = districtRepository.findByCityByCitiId(cityId);
        if(districts.isEmpty())
            throw new DistrictException("no district found");
        return districts;
    }
}
