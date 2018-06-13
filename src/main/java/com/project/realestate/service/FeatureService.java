package com.project.realestate.service;

import com.project.realestate.entity.Feature;
import com.project.realestate.exception.FeatureException;

import java.util.List;

public interface FeatureService {
    List<Feature> findAll();
    Feature findById(String id);
    void save(String id, Feature feature);
    void delete(String id);
}
