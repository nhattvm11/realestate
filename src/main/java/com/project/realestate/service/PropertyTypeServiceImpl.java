package com.project.realestate.service;

import com.project.realestate.entity.PropertyType;
import com.project.realestate.exception.PropertyTypeException;
import com.project.realestate.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyTypeServiceImpl implements PropertyTypeService{

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;


    @Override
    public List<PropertyType> findAll() throws PropertyTypeException {
        List<PropertyType> propertyTypes = propertyTypeRepository.findAll();
        if(propertyTypes.isEmpty())
            throw new PropertyTypeException("no propertyType found");
        return propertyTypes;
    }

    @Override
    public PropertyType findById(String id) throws PropertyTypeException {
        PropertyType propertyType = propertyTypeRepository.findPropertyTypeById(id);
        if(propertyType == null)
            throw new PropertyTypeException();
        return propertyType;
    }

    @Override
    public PropertyType findByName(String property) throws PropertyTypeException {
        PropertyType propertyType = propertyTypeRepository.findPropertyTypeByPropertyName(property);
        if (propertyType == null)
            throw new PropertyTypeException("no property found");
        return propertyType;
    }
}
