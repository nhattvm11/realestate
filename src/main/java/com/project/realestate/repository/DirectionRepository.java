package com.project.realestate.repository;

import com.project.realestate.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectionRepository extends JpaRepository<Direction, String> {
    @Override
    List<Direction> findAll();
}
