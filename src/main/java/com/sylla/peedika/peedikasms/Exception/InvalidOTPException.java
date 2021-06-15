package com.sylla.peedika.peedikasms.Exception;

public class InvalidOTPException extends RuntimeException{
        private static final long serialVersionUID = 1L;
        public InvalidOTPException(String exception) {
            super(exception);
        }

}
