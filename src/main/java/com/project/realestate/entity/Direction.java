package com.project.realestate.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Direction {
    private String id;
    private String directionName;
    private Date createAt;
    private Date updateAt;
    private Collection<Article> articlesById;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "direction_name")
    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
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
    @Column(name = "updateAt")
    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        if (id != null ? !id.equals(direction.id) : direction.id != null) return false;
        if (directionName != null ? !directionName.equals(direction.directionName) : direction.directionName != null)
            return false;
        if (createAt != null ? !createAt.equals(direction.createAt) : direction.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(direction.updateAt) : direction.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (directionName != null ? directionName.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "directionByDirectionId")
    public Collection<Article> getArticlesById() {
        return articlesById;
    }

    public void setArticlesById(Collection<Article> articlesById) {
        this.articlesById = articlesById;
    }
}
