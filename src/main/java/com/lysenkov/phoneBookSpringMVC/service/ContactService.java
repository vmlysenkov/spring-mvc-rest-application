package com.lysenkov.phoneBookSpringMVC.service;

import com.lysenkov.phoneBookSpringMVC.entity.Contact;
import com.lysenkov.phoneBookSpringMVC.exception.ContactsException;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    Contact findContactByName(String name) throws ContactsException;

    Contact addPhoneToExistingName(String name, String phone) throws ContactsException;

    Contact addContact(Contact newContact);

    void removePhone(String name) throws ContactsException;

}