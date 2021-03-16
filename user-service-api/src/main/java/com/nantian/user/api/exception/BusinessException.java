package com.nantian.user.api.exception;

/**
 * @author WangJinYi 2021/3/8
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -5433056591268198786L;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
