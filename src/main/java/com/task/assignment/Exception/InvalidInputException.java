package com.task.assignment.Exception;

public class InvalidInputException extends  RuntimeException{
    public InvalidInputException(String message) {
        super(message);
    }
    public InvalidInputException(String message  , Throwable cause) {
        super(message,cause);
    }
}
