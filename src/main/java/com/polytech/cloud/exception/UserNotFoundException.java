package com.polytech.cloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown whenever one tries to retrieve a user that does not exist in the database.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends UserException {

    public UserNotFoundException() { }

    public UserNotFoundException(Throwable e) {
        super(e);
    }

    public UserNotFoundException(String cause) {
        super(cause);
    }

    public UserNotFoundException(String cause, Throwable e) {
        super(cause, e);
    }

}
