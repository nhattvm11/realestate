package com.project.realestate.service;

import com.project.realestate.entity.Contact;
import com.project.realestate.entity.User;


public interface ContactService {
    void saveContact(Contact contact);
    Contact findById(String id);
    Contact getContactByUserByUserId(User user);
}
