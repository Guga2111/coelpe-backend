package com.coelpe.coelpe.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("The id '" + id + "' doesn't belong to our records!");
    }
}
