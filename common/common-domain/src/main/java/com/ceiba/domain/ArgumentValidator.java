package com.ceiba.domain;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ceiba.domain.exception.LengthValueException;
import com.ceiba.domain.exception.InvalidValueException;
import com.ceiba.domain.exception.ValueRequiredException;

public class ArgumentValidator {
	
	private ArgumentValidator() {}

    public static void validateRequired(Object value, String message) {
        if (value == null) {
            throw new ValueRequiredException(message);
        }
    }
    
    public static void validateLength(String value, int length, String message){
        if(value.length() < length){
            throw new LengthValueException(message);
        }
    }
    
    public static <T> void validateNotEmpty(List<T> list, String message) {
        if (list.isEmpty()) {
            throw new ValueRequiredException(message);
        }
    }

    public static void validatePositive(Double value, String message) {
        if (value <= 0) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateEquals(Double value, Double expectedValue, String message) {
        if (!value.equals(expectedValue)) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateMinimumLength(Object value, int minimumLength, String message) {
        if (value.toString().length() < minimumLength) {
            throw new LengthValueException(message);
        }
    }

    public static void validateMinor(LocalDateTime initialDate, LocalDateTime endDate, String message) {
        if (initialDate.toLocalDate().isAfter(endDate.toLocalDate())) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateMinor(Long initialNumber, Long endNumber, String message) {
        if (initialNumber > endNumber) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateRegex(String value, String regex, String message) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if (!matcher.matches()) {
            throw new InvalidValueException(message);
        }
    }

    public static <E extends Enum<E>> E validateValid(String value, Class<E> enumToGet, String message) {
        E enumObtained = null;
        if(null != value) {
            Optional<E> optionalResult = Arrays.stream(enumToGet.getEnumConstants())
                    .filter(result -> result.toString().equals(value)).findFirst();

            if (optionalResult.isPresent()) {
                enumObtained = optionalResult.get();
            } else {
                throw new InvalidValueException(message);
            }
        }
        return enumObtained;
    }

    public static void ValidateNumeric(String value, String message) {
        try {
            Long.parseLong(value);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidValueException(message);
        }
    }
}
