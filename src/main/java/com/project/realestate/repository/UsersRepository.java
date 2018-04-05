package com.project.realestate.repository;

import com.project.realestate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UsersRepository extends JpaRepository<User, Integer> {
    User findUsersByUsername(String name);
    User findUserById(int id);
}
