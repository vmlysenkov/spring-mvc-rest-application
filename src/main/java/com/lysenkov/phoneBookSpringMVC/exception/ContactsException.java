package com.lysenkov.phoneBookSpringMVC.exception;

import javassist.NotFoundException;

public class ContactsException extends NotFoundException {

    public ContactsException(String msg) {
        super(msg);
    }

    public ContactsException(String msg, Exception e) {
        super(msg, e);
    }
}
