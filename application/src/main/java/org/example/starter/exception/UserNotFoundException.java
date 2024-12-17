package org.example.starter.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super("User " + userId + " not found");
    }

}
