package com.kodilla.carrental.exception;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Class<?> clazz, Long id){
        super(String.format("Entity %s with id: %d not found.", clazz.getSimpleName(), id));
    }
}
