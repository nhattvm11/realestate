package com.project.realestate.repository;

import com.project.realestate.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature, String> {
    @Override
    List<Feature> findAll();
    Feature findFeatureById(String id);
}
