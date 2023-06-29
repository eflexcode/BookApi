package com.larrex.bookapi.exception;

public class ResourceNotFoundException extends RuntimeException {

    public final static long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
