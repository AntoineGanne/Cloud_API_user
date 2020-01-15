package com.polytech.cloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown whenever one tries to retrieve a user that does not exist in the database.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NegativePageException extends RuntimeException {

    private NegativePageException() {
    }

    public NegativePageException(String cause) {
        super(cause);
    }

    public NegativePageException(String cause, Throwable e) {
        super(cause, e);
    }

}
