package com.ceiba.domain.exception;

public class ValueRequiredException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ValueRequiredException(String message) {
        super(message);
    }
}
