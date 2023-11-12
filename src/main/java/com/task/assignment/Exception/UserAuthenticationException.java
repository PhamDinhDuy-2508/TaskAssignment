package com.task.assignment.Exception;

public class UserAuthenticationException extends RuntimeException {
    public UserAuthenticationException(String explanation) {
        super(explanation);
    }

    public UserAuthenticationException() {
    }
}
