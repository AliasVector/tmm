package com.mar.tmm.exception;

/**
 * Application base exception.
 */
public class TmmException extends RuntimeException {
    public TmmException() {
    }

    public TmmException(final String message) {
        super(message);
    }

    public TmmException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TmmException(final Throwable cause) {
        super(cause);
    }
}
