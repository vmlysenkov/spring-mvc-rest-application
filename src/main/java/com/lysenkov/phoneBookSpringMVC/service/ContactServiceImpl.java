package com.lysenkov.phoneBookSpringMVC.service;

import com.lysenkov.phoneBookSpringMVC.entity.Contact;
import com.lysenkov.phoneBookSpringMVC.exception.ContactsException;
import com.lysenkov.phoneBookSpringMVC.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findContactByName(String name) throws ContactsException {
        return Optional.ofNullable(contactRepository.findContactByName(name))
                .orElseThrow(() -> new ContactsException("Could not find user with name " + name));
    }

    @Override
    public Contact addPhoneToExistingName(String name, String phone) throws ContactsException {
        Contact contact = Optional.ofNullable(contactRepository.findContactByName(name))
                .orElseThrow(() -> new ContactsException("Could not find user with name " + name));
        contact.addPhone(phone);
        return contactRepository.save(contact);
    }

    @Override
    public Contact addContact(Contact newContact) {
        return contactRepository.save(newContact);
    }

    @Override
    public void removePhone(String name) throws ContactsException {
        Contact contact = Optional.ofNullable(contactRepository.findContactByName(name))
                .orElseThrow(() -> new ContactsException("Could not find user with name " + name));
        contactRepository.delete(contact);
    }

}
