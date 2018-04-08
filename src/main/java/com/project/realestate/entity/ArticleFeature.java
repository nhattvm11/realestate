package com.project.realestate.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "article_feature", schema = "realestate", catalog = "")
public class ArticleFeature {
    private String id;
    private Date createAt;
    private Date lastUpdate;
    private Article articleByArticleId;
    private Feature featureByFeatureId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "createAt")
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "lastUpdate")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleFeature that = (ArticleFeature) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "articleId", referencedColumnName = "id", nullable = false)
    public Article getArticleByArticleId() {
        return articleByArticleId;
    }

    public void setArticleByArticleId(Article articleByArticleId) {
        this.articleByArticleId = articleByArticleId;
    }

    @ManyToOne
    @JoinColumn(name = "featureId", referencedColumnName = "id", nullable = false)
    public Feature getFeatureByFeatureId() {
        return featureByFeatureId;
    }

    public void setFeatureByFeatureId(Feature featureByFeatureId) {
        this.featureByFeatureId = featureByFeatureId;
    }
}
