package com.project.realestate.service;

import com.project.realestate.entity.Direction;
import com.project.realestate.exception.DirectionException;

import java.util.List;

public interface DirectionSerVice {
    public List<Direction> findAll() throws DirectionException;
    public Direction findById(String id) throws DirectionException;
}
