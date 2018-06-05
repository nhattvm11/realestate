package com.project.realestate.service;

import com.project.realestate.entity.Type;
import com.project.realestate.exception.TypeException;

import java.util.List;

public interface TypeService {
    List<Type> findAll() throws TypeException;
    Type findById(String id) throws TypeException;
    Type findTypeByName(String type) throws TypeException;
}
