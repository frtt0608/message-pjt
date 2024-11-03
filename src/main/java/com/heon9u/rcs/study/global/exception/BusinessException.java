package com.heon9u.rcs.study.global.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }


    // lock stack
    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
