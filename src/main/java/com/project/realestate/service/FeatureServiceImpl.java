package com.project.realestate.service;

import com.project.realestate.entity.Feature;
import com.project.realestate.exception.FeatureException;
import com.project.realestate.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    FeatureRepository featureRepository;

    @Override
    public List<Feature> findAll() throws FeatureException {
        List<Feature> features = featureRepository.findAll();
        if (features.isEmpty())
            throw new FeatureException("no feature found");
        return features;
    }
}
