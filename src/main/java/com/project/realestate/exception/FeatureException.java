package com.project.realestate.exception;

public class FeatureException extends Exception {

    public FeatureException(String s) {
        super(s);
    }

    public FeatureException() {
        super();
    }

    public FeatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeatureException(Throwable cause) {
        super(cause);
    }

    protected FeatureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
