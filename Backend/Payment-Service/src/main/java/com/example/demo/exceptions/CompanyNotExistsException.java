package com.example.demo.exceptions;

public class CompanyNotExistsException extends CouponSystemException {
    private static final long serialVersionUID = 1L;

    public CompanyNotExistsException() {
    }

    public CompanyNotExistsException(String message) {
        super(message);
    }

    public CompanyNotExistsException(Throwable cause) {
        super(cause);
    }

    public CompanyNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyNotExistsException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
