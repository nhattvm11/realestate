package com.project.realestate.repository;

import com.project.realestate.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, String> {
    @Override
    List<Type> findAll();
    Type findTypeById(String id);
}
