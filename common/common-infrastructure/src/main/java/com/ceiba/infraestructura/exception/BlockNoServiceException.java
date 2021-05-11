package com.ceiba.infraestructura.exception;

public class BlockNoServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BlockNoServiceException(String message) {
        super(message);
    }
}
