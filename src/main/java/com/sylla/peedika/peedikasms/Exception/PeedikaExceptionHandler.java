package com.sylla.peedika.peedikasms.Exception;

import com.sylla.peedika.peedikasms.model.repsonse.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PeedikaExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<ErrorResponse> handleInternalServerError(ServiceException serverException) {
        return generateErrorResponse(serverException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(InvalidOTPException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<ErrorResponse> handleInternalServerError(InvalidOTPException serverException) {
        return generateErrorResponse(serverException, HttpStatus.UNAUTHORIZED);
    }

    private ResponseEntity<ErrorResponse> generateErrorResponse(Exception ex, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErroCode(String.valueOf(httpStatus.value()));
        errorResponse.setErrorMessage(ex.getLocalizedMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, httpStatus);
    }
}
