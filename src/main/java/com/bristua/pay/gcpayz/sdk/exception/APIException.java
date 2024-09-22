package com.bristua.pay.gcpayz.sdk.exception;

/**
 * API异常
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-08 11:00
 */
public class APIException extends GcPayzException {

    private static final long serialVersionUID = -2753719317464278319L;

    public APIException(String message, String type, String code, int statusCode, Throwable e) {
        super(message, statusCode, e);
    }
}
