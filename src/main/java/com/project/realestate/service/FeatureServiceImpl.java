package com.project.realestate.service;

import com.project.realestate.entity.ArticleFeature;
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

    @Autowired
    ArticleFeatureService articleFeatureService;

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
    public void save(String id, Feature feature) {
        if (id == null) {
            feature.setId(UUID.randomUUID().toString());
            featureRepository.save(feature);
        }else {
            Feature featureSave = featureRepository.findFeatureById(id);
            featureSave.setFeatureName(feature.getFeatureName());
            featureRepository.save(featureSave);
        }
    }

    @Override
    public void delete(String id) {
        List<ArticleFeature> articleFeatures = articleFeatureService.findArticleFeatureBYFeature(featureRepository.findFeatureById(id));
        for (ArticleFeature articleFeature : articleFeatures){
            articleFeatureService.deleteArticleFeature(articleFeature);
        }
        featureRepository.deleteById(id);
    }

}
