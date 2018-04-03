package com.project.realestate.service;

import com.project.realestate.entity.User;

public interface EmailService {
    void sendMailConfirmation(User user);
}
