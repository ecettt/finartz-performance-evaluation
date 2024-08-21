package com.finartz.userregistration.exception;

public class UserNotRegisteredException extends RuntimeException{
    public UserNotRegisteredException(String message) {
        super(message);
    }
}
