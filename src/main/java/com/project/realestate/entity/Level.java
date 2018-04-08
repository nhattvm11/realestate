package com.project.realestate.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Level {
    private String id;
    private String levelName;
    private Collection<User> usersById;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "level_name")
    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level level = (Level) o;

        if (id != null ? !id.equals(level.id) : level.id != null) return false;
        if (levelName != null ? !levelName.equals(level.levelName) : level.levelName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (levelName != null ? levelName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "levelByLevelId")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
