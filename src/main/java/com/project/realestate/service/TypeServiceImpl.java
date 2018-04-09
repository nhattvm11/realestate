package com.project.realestate.service;

import com.project.realestate.entity.Type;
import com.project.realestate.exception.TypeException;
import com.project.realestate.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> findAll() throws TypeException{
        List<Type> types = typeRepository.findAll();
        if (types.isEmpty()){
            throw new TypeException("no type found");
        }
        return types;
    }

    @Override
    public Type findById(String id) throws TypeException {
        Type type = typeRepository.findTypeById(id);
        if (type == null)
            throw new TypeException();
        return type;
    }
}
