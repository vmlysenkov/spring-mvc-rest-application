package com.lysenkov.phoneBookSpringMVC.repository;

import com.lysenkov.phoneBookSpringMVC.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findContactByName(String name);
}