package com.company.application.exception;

import org.springframework.validation.FieldError;

import java.util.List;

public class ValidationException extends Exception{

    private List<FieldError> errorMessages;

    public ValidationException(List<FieldError> errorList){
        this.errorMessages = errorList;
    }

    public List<FieldError> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<FieldError> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
