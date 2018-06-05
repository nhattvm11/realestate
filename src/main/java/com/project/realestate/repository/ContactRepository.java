package com.project.realestate.repository;

import com.project.realestate.entity.Contact;
import com.project.realestate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, String> {
    Contact getContactById(String id);
    Contact getContactByUserByUserId(User user);
}
