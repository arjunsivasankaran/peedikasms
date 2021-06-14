package com.sylla.peedika.peedikasms.Exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceException(String exception) {
        super(exception);
    }
}
