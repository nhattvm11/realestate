package com.project.realestate.repository;

import com.project.realestate.entity.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, String> {
    @Override
    List<PropertyType> findAll();
    PropertyType findPropertyTypeById(String id);
}
