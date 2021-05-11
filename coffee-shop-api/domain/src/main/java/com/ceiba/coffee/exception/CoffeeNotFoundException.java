package com.ceiba.coffee.exception;

public class CoffeeNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CoffeeNotFoundException(String message) {
        super(message);
    }
}
