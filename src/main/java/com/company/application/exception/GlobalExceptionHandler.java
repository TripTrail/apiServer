package com.company.application.exception;

import com.company.application.co.APIResponse;
import com.company.application.co.ValidationMessageCO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static com.company.application.constants.Constant.INTERNAL_SERVER_ERROR;
import static com.company.application.constants.Constant.NULL;
import static java.lang.Boolean.FALSE;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIResponse> handleApplicationException(RuntimeException ex){
        ex.printStackTrace();
        APIResponse response = new APIResponse<>(FALSE, INTERNAL_SERVER_ERROR, NULL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<APIResponse> handleValidationException(ValidationException ex){
        ValidationMessageCO validationMessageCO = new ValidationMessageCO();
        List<String> errorMessages = new ArrayList<>();
        ex.getErrorMessages().forEach(fieldError -> {
            errorMessages.add(fieldError.getDefaultMessage());
        });
        validationMessageCO.setValidationErrors(errorMessages);
        APIResponse<ValidationMessageCO> response = new APIResponse<>(
                FALSE, validationMessageCO.getValidationErrors().get(0), validationMessageCO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
