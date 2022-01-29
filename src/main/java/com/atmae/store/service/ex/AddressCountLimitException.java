package com.atmae.store.service.ex;

/**
 * 收获地址总数超出限制异常(20条)
 * @author Mae
 */
public class AddressCountLimitException extends ServiceException{
    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    protected AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AddressCountLimitException() {
        super();
    }

    public AddressCountLimitException(String message) {
        super(message);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }
}
