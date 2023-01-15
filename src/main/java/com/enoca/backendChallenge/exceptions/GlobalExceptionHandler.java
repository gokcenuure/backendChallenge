package com.enoca.backendChallenge.exceptions;

import com.enoca.backendChallenge.core.results.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<ErrorResult> handleCompanyNotFoundException(CompanyNotFoundException ex) {
        ErrorResult error = new ErrorResult("Error: " + ex.getMessage());
        error.setErrorCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        error.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorResult>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResult> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ErrorResult error = new ErrorResult("Error: " + ex.getMessage());
        error.setErrorCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        error.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorResult>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidEmployeeIdException.class)
    public ResponseEntity<ErrorResult> handleInvalidEmployeeIdException(InvalidEmployeeIdException ex) {
        ErrorResult error = new ErrorResult("Invalid employee id", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidEmployeeEmailException.class)
    public ResponseEntity<ErrorResult> handleInvalidEmployeeEmailException(InvalidEmployeeEmailException ex) {
        ErrorResult error = new ErrorResult("Invalid employee email", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidEmployeePhoneNumberException.class)
    public ResponseEntity<ErrorResult> handleInvalidEmployeePhoneNumberException(InvalidEmployeePhoneNumberException ex) {
        ErrorResult error = new ErrorResult("Invalid employee phone number", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidCompanyIdException.class)
    public ResponseEntity<ErrorResult> handleInvalidCompanyIdException(InvalidCompanyIdException ex) {
        ErrorResult error = new ErrorResult("Invalid company id", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCompanyNameException.class)
    public ResponseEntity<ErrorResult> handleInvalidCompanyNameException(InvalidCompanyNameException ex) {
        ErrorResult error = new ErrorResult("Invalid company name", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResult> handleException(Exception ex) {
        ErrorResult error = new ErrorResult("Error: " + ex.getMessage());
        error.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        error.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorResult>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
