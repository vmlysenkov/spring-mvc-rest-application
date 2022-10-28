package com.lysenkov.phoneBookSpringMVC.controllers;

import com.lysenkov.phoneBookSpringMVC.entity.Contact;
import com.lysenkov.phoneBookSpringMVC.exception.ContactsException;
import com.lysenkov.phoneBookSpringMVC.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactsController {

    private final ContactService contactService;

    @Autowired
    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    List<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @GetMapping("/{name}")
    Contact findContactByName(@PathVariable String name) throws ContactsException {
        return contactService.findContactByName(name);
    }

    @PutMapping("/{name}")
    Contact addPhoneToExistingName(@PathVariable String name, @RequestParam("phone") String phone) throws ContactsException {
        return contactService.addPhoneToExistingName(name, phone);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Contact newContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @DeleteMapping(value = "/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removePhone(@PathVariable String name) throws ContactsException {
        contactService.removePhone(name);
    }
}
