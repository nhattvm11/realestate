package com.project.realestate.service;

import com.project.realestate.entity.PropertyType;
import com.project.realestate.exception.PropertyTypeException;

import java.util.List;

public interface PropertyTypeService {
    List<PropertyType> findAll() throws PropertyTypeException;
    PropertyType findById(String id) throws PropertyTypeException;
    PropertyType findByName(String property) throws PropertyTypeException;
}
