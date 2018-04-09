package com.project.realestate.service;

import com.project.realestate.entity.Type;
import com.project.realestate.exception.TypeException;

import java.util.List;

public interface TypeService {
    public List<Type> findAll() throws TypeException;
    public Type findById(String id) throws TypeException;
}
