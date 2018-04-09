package com.project.realestate.exception;

public class DistrictException extends Exception {
    public DistrictException(String s) {
        super(s);
    }

    public DistrictException() {
        super();
    }

    public DistrictException(String message, Throwable cause) {
        super(message, cause);
    }

    public DistrictException(Throwable cause) {
        super(cause);
    }

    protected DistrictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
