package com.ceiba.domain.exception;

public class DuplicityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicityException(String message) {
        super(message);
    }
}
