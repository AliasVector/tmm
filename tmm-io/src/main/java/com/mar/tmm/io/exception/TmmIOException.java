package com.mar.tmm.io.exception;

import com.mar.tmm.exception.TmmException;

/**
 * Application base exception from input output operations.
 */
public class TmmIOException extends TmmException {
    public TmmIOException() {
    }

    public TmmIOException(final String message) {
        super(message);
    }

    public TmmIOException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TmmIOException(final Throwable cause) {
        super(cause);
    }
}
