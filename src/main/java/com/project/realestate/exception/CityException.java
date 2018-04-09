package com.project.realestate.exception;

public class CityException extends Exception {
    public CityException(String s) {
        super(s);
    }

    public CityException() {
        super();
    }

    public CityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CityException(Throwable cause) {
        super(cause);
    }

    protected CityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
