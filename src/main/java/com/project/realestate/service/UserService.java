package com.project.realestate.service;

import com.project.realestate.entity.User;
import com.project.realestate.exception.UserNotFoundException;

public interface UserService {
    User getUserById(int id) throws UserNotFoundException;
    void updateUser(User user);
    void register(User user);
    void confirmRegistration(String token);
    void saveUser(User user);
}
