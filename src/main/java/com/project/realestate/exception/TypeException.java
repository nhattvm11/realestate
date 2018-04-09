package com.project.realestate.exception;

public class TypeException extends Exception {
    public TypeException(String s) {
        super(s);
    }

    public TypeException() {
        super();
    }

    public TypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeException(Throwable cause) {
        super(cause);
    }

    protected TypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
