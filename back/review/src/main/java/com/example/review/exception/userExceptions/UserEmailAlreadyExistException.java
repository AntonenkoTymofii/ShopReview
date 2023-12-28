package com.example.review.exception.userExceptions;

public class UserEmailAlreadyExistException extends Exception {
    public UserEmailAlreadyExistException(String message) {
        super(message);
    }
}
