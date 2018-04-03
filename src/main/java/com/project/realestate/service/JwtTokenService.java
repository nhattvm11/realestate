package com.project.realestate.service;

import com.project.realestate.entity.User;
import com.project.realestate.exception.ConfirmationException;
import com.project.realestate.exception.TokenInvalidException;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.exception.UsernameExistException;

public interface JwtTokenService {
    String getToken(User user);

    String verifyToken(String token) throws TokenInvalidException, UserNotFoundException, UsernameExistException, ConfirmationException;
}
