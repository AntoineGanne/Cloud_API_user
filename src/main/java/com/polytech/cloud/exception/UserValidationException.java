package com.polytech.cloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown whenever one tries to create a non-conform user.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserValidationException extends UserException {

    public UserValidationException() { }

    public UserValidationException(Throwable e) {
        super(e);
    }

    public UserValidationException(String cause) {
        super(cause);
    }

    public UserValidationException(String cause, Throwable e) {
        super(cause, e);
    }

}
