package com.student.ust.exception;

import com.student.ust.exception.BussinessException;

/**
 * The type Invalid exception.
 */
public class InvalidException extends BussinessException {

    /**
     * Instantiates a new Invalid exception.
     */
    public InvalidException()
    {
        super("Invalid Entry Please check your email and password");
    }
}
