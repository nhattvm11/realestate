package com.project.realestate.service;

import com.project.realestate.entity.Contact;
import com.project.realestate.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Contact findById(String id) {
        return contactRepository.getContactById(id);
    }

}
