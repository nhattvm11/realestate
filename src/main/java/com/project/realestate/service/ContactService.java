package com.project.realestate.service;

import com.project.realestate.entity.Contact;
import com.project.realestate.entity.User;
import com.project.realestate.model.ContactTemp;

import java.util.List;


public interface ContactService {
    void saveContact(Contact contact);
    Contact findById(String id);
    List<Contact> getContactByUserByUserId(User user);
    Contact getMainContact(User user);

    Contact parseContactModelToEntity(String id, ContactTemp contactTemp);
}
