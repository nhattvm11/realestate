package com.project.realestate.service;

import com.project.realestate.entity.Feature;
import com.project.realestate.exception.FeatureException;
import com.project.realestate.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    FeatureRepository featureRepository;

    @Override
    public List<Feature> findAll() {
        List<Feature> features = featureRepository.findAll();
        return features;
    }

    @Override
    public Feature findById(String id) {
        Feature feature = featureRepository.findFeatureById(id);
        return feature;
    }

    @Override
    public void save(Feature feature) {
        feature.setId(UUID.randomUUID().toString());
        featureRepository.save(feature);
    }

    @Override
    public void delete(String id) {

        featureRepository.deleteById(id);
    }

}
