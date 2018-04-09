package com.project.realestate.service;

import com.project.realestate.entity.Direction;
import com.project.realestate.exception.DirectionException;
import com.project.realestate.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionServiceImpl implements DirectionSerVice {

    @Autowired
    DirectionRepository directionRepository;

    @Override
    public List<Direction> findAll() throws DirectionException {
        List<Direction> directions = directionRepository.findAll();
        if(directions.isEmpty())
            throw new DirectionException();
        return directions;
    }

    @Override
    public Direction findById(String id) throws DirectionException {
        Direction direction = directionRepository.findDirectionById(id);
        if (direction == null)
            throw new DirectionException();
        return direction;
    }
}
