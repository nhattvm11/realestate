package com.project.realestate.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Feature {
    private String id;
    private String featureName;
    private Collection<ArticleFeature> articleFeaturesById;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "feature_name")
    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feature feature = (Feature) o;

        if (id != null ? !id.equals(feature.id) : feature.id != null) return false;
        if (featureName != null ? !featureName.equals(feature.featureName) : feature.featureName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (featureName != null ? featureName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "featureByFeatureId")
    public Collection<ArticleFeature> getArticleFeaturesById() {
        return articleFeaturesById;
    }

    public void setArticleFeaturesById(Collection<ArticleFeature> articleFeaturesById) {
        this.articleFeaturesById = articleFeaturesById;
    }
}
