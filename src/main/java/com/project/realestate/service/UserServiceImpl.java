package com.project.realestate.service;

import com.project.realestate.entity.User;
import com.project.realestate.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void register(User user) {

    }

    @Override
    public void confirmRegistration(String token) {

    }

    @Override
    public void saveUser(User user) {

    }
}
