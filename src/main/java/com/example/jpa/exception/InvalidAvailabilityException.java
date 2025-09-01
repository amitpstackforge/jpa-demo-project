package com.example.jpa.exception;

public class InvalidAvailabilityException extends RuntimeException {
    public InvalidAvailabilityException(String message) {
        super(message);
    }
}
