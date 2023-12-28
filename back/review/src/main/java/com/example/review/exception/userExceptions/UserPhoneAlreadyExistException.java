package com.example.review.exception.userExceptions;

public class UserPhoneAlreadyExistException extends Exception{
    public UserPhoneAlreadyExistException(String message) {
        super(message);
    }
}
