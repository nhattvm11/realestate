package com.project.realestate.exception;

public class ArticleException extends Exception {
    public ArticleException(String s) {
        super(s);
    }

    public ArticleException() {
        super();
    }

    public ArticleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleException(Throwable cause) {
        super(cause);
    }

    protected ArticleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
