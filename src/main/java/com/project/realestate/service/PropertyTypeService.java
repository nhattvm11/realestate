package com.project.realestate.service;

import com.project.realestate.entity.PropertyType;
import com.project.realestate.exception.PropertyTypeException;

import java.util.List;

public interface PropertyTypeService {
    public List<PropertyType> findAll() throws PropertyTypeException;
    public PropertyType findById(String id) throws PropertyTypeException;
}
