package com.unimarket.unimarket.core.exception;

public class UserAlreadyRegistered extends RuntimeException {

    public UserAlreadyRegistered() {
        super("Already registered user!");
    }
}
