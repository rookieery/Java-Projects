package com.lu.exception;

public class BusinessException extends RuntimeException {
    private String code;

    public BusinessException(String message) {
        super("业务异常" + message);
        code = "401";
    }

    public BusinessException(String message, Throwable cause) {
        super("业务异常" + message, cause);
        code = "401";
    }
}
