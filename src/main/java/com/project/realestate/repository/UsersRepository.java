package com.project.realestate.repository;

import com.project.realestate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, String> {
    User findUsersByUsername(String name);
    User findUserById(String id);
}
