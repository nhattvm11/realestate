package com.project.realestate.repository;

import com.project.realestate.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {
    Contact getContactById(String id);
}
