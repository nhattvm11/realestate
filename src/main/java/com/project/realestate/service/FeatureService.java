package com.project.realestate.service;

import com.project.realestate.entity.Feature;
import com.project.realestate.exception.FeatureException;

import java.util.List;

public interface FeatureService {
    public List<Feature> findAll() throws FeatureException;
}
