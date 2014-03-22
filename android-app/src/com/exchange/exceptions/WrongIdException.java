package com.exchange.exceptions;

/**
 * @author vlad.fargutu
 */
public class WrongIdException extends Exception {

    public WrongIdException() {
        super();
    }

    @Override
    public String getMessage() {
        return String.format("%s: The identifier is wrong!", getClass().getSimpleName());
    }
}
