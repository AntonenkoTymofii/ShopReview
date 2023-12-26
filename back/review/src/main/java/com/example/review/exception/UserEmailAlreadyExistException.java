package com.example.review.exception;

public class UserEmailAlreadyExistException extends Exception {
    public UserEmailAlreadyExistException(String message) {
        super(message);
    }
}
