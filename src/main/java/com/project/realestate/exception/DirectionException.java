package com.project.realestate.exception;

public class DirectionException extends Exception {
    public DirectionException(String s) {
        super(s);
    }

    public DirectionException() {
        super();
    }

    public DirectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DirectionException(Throwable cause) {
        super(cause);
    }

    protected DirectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
