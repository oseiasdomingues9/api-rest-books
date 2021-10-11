package com.devchallenge.apirestbooks.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Long id) {
        super("ID " + id + " not found");
    }
}
