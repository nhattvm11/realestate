package com.project.realestate.service;

import com.project.realestate.entity.Contact;
import com.project.realestate.entity.User;
import com.project.realestate.model.ContactTemp;
import com.project.realestate.repository.ContactRepository;
import com.project.realestate.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Contact findById(String id) {
        return contactRepository.getContactById(id);
    }

    @Override
    public List<Contact> getContactByUserByUserId(User user) {
        return contactRepository.getContactByUserByUserId(user);
    }

    @Override
    public Contact getMainContact(User user) {
        return contactRepository.getContactByUserByUserIdAndMainContactTrue(user);
    }

    @Override
    public Contact parseContactModelToEntity(String id, ContactTemp contactTemp) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        User user = usersRepository.findUserByUsername(userDetails.getUsername());
        Contact contact = contactRepository.getContactById(id);
        contact.setAddress(contactTemp.getAddress());
        contact.setPhone(contactTemp.getPhone());
        contact.setContactName(contactTemp.getContactName());
        contact.setEmail(contactTemp.getEmail());
        return contact;
    }

}
