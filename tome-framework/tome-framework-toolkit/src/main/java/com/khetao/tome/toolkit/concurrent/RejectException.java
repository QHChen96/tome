package com.khetao.tome.toolkit.concurrent;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public class RejectException extends RuntimeException {

    public RejectException() {}

    public RejectException(final String message) {
        super(message);
    }

    public RejectException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RejectException(final Throwable cause) {
        super(cause);
    }

}
