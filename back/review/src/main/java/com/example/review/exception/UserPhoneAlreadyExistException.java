package com.example.review.exception;

public class UserPhoneAlreadyExistException extends Exception{
    public UserPhoneAlreadyExistException(String message) {
        super(message);
    }
}
