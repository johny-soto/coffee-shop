package com.ceiba.domain.exception;

public class InvalidValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public InvalidValueException(String message) {
        super(message);
    }
}
