package com.bristua.pay.gcpayz.sdk.exception;

/**
 * 无效请求异常
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-08 11:00
 */
public class InvalidRequestException extends GcPayzException {

    private static final long serialVersionUID = 3163726141488238321L;

    public InvalidRequestException(String message, int statusCode, Throwable e) {
        super(message, statusCode, e);
    }

}
