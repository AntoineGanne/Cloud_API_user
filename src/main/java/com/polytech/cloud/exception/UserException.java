package com.polytech.cloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown whenever any error happens while manipulating an user.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserException extends RuntimeException {

    public UserException() {
    }

    public UserException(Throwable e) {
        super(e);
    }

    public UserException(String cause) {
        super(cause);
    }

    public UserException(String cause, Throwable e) {
        super(cause, e);
    }

}
