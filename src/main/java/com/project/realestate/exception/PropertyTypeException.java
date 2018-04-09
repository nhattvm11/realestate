package com.project.realestate.exception;

public class PropertyTypeException extends Exception {
    public PropertyTypeException(String s) {
        super(s);
    }

    public PropertyTypeException() {
        super();
    }

    public PropertyTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertyTypeException(Throwable cause) {
        super(cause);
    }

    protected PropertyTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
