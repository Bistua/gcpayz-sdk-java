package com.bristua.pay.gcpayz.sdk.exception;

/**
 * GcPayz异常抽象类
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-08 11:00
 */
public abstract class GcPayzException extends Exception {

    private static final long serialVersionUID = 2566087783987900120L;

    private int statusCode;

    public GcPayzException(String message) {
        super(message, null);
    }

    public GcPayzException(String message, Throwable e) {
        super(message, e);
    }

    public GcPayzException(String message, int statusCode, Throwable e) {
        super(message, e);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
                return sb.toString();
    }
}
