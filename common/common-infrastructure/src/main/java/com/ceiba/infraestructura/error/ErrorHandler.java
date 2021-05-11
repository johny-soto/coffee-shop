package com.ceiba.infraestructura.error;


import java.util.concurrent.ConcurrentHashMap;

import com.ceiba.infraestructura.exception.TechnicalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.domain.exception.DuplicityException;
import com.ceiba.domain.exception.LengthValueException;
import com.ceiba.domain.exception.NoDataException;
import com.ceiba.domain.exception.InvalidValueException;
import com.ceiba.domain.exception.ValueRequiredException;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ErrorHandler.class);

    private static final String AN_ERROR_OCCURRED_PLEASE_CONTACT_THE_ADMINISTRATOR = "Ocurrio un error favor contactar al administrador.";

    private static final ConcurrentHashMap<String, Integer> STATUS_ERROR = new ConcurrentHashMap<>();

    public ErrorHandler() {
        STATUS_ERROR.put(LengthValueException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_ERROR.put(InvalidValueException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_ERROR.put(NoDataException.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        STATUS_ERROR.put(ValueRequiredException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_ERROR.put(DuplicityException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_ERROR.put(TechnicalException.class.getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR.value());

        
        //en caso de tener otra excepcion matricularla aca
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> result;

        String nameException = exception.getClass().getSimpleName();
        String message = exception.getMessage();
        Integer code = STATUS_ERROR.get(nameException);

        if (code != null) {
            Error error = new Error(nameException, message);
            result = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        } else {
            LOGGER_ERROR.error(nameException, exception);
            Error error = new Error(nameException, AN_ERROR_OCCURRED_PLEASE_CONTACT_THE_ADMINISTRATOR);
            result = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }
    
    
    
}