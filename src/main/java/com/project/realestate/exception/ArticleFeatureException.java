package com.project.realestate.exception;

public class ArticleFeatureException extends Exception {
    public ArticleFeatureException(String s) {
        super(s);
    }

    public ArticleFeatureException() {
        super();
    }

    public ArticleFeatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleFeatureException(Throwable cause) {
        super(cause);
    }

    protected ArticleFeatureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
