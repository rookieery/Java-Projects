package com.lu.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemException extends RuntimeException {
    private String code;

    public SystemException(String message) {
        super("系统异常" + message);
        code = "501";
    }

    public SystemException(String message, Throwable cause) {
        super("系统异常" + message, cause);
        code = "501";
    }
}
