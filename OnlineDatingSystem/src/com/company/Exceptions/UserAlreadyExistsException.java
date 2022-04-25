package com.company.Exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String username_already_exists) {
        super(username_already_exists);
    }
}
