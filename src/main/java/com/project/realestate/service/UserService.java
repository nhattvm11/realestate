package com.project.realestate.service;

import com.project.realestate.entity.User;
import com.project.realestate.exception.ConfirmationException;
import com.project.realestate.exception.TokenInvalidException;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.exception.UsernameExistException;

public interface UserService {
    User getUserById(String id) throws UserNotFoundException;
    User getUSerByEmail(String email) throws UserNotFoundException;
    void updateFirstToken(User user) throws UsernameExistException;
    void register(User user);
    void confirmRegistration(String token) throws TokenInvalidException, UsernameExistException, ConfirmationException, UserNotFoundException;
    void saveUser(User user);
    void resetPassword(String token) throws TokenInvalidException, UsernameExistException, ConfirmationException, UserNotFoundException;
}
