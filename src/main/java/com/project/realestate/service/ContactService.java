package com.project.realestate.service;

import com.project.realestate.entity.Contact;

public interface ContactService {
    void saveContact(Contact contact);
    Contact findById(String id);
}
