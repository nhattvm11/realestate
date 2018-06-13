package com.project.realestate.service;

import com.project.realestate.entity.ArticleFeature;
import com.project.realestate.entity.PropertyType;
import com.project.realestate.exception.PropertyTypeException;
import com.project.realestate.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PropertyTypeServiceImpl implements PropertyTypeService{

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    @Autowired
    private ArticleFeatureService articleFeatureService;

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

    @Override
    public void save(String id, PropertyType propertyType) {
        if (id == null){
            propertyType.setId(UUID.randomUUID().toString());
            propertyTypeRepository.save(propertyType);
        }else {
            PropertyType propertyTypeS = propertyTypeRepository.findPropertyTypeById(id);
            propertyTypeS.setPropertyName(propertyType.getPropertyName());
            propertyTypeRepository.save(propertyType);
        }

    }

}
