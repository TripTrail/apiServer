package com.company.application.exception;

import static com.company.application.constants.Constant.INTERNAL_SERVER_ERROR;
import static com.company.application.constants.Constant.NULL;
import static java.lang.Boolean.FALSE;

import com.company.application.co.APIResponse;
import com.company.application.co.ValidationMessageCO;
import com.company.application.config.MessageHelper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class GlobalExceptionHandler {

  @Autowired
  private MessageHelper messageHelper;

  @ExceptionHandler(Exception.class)
  public ResponseEntity<APIResponse> handleApplicationException(RuntimeException ex) {
    ex.printStackTrace();
    APIResponse response = new APIResponse<>(FALSE, messageHelper.getMessage(INTERNAL_SERVER_ERROR), NULL);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @ExceptionHandler(GenericException.class)
  public ResponseEntity<APIResponse> handleGenericException(GenericException ex) {
    ex.printStackTrace();
    APIResponse<String> response = new APIResponse<>(FALSE, ex.getMessage(), NULL);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<APIResponse> handleValidationException(ValidationException ex) {
    ValidationMessageCO validationMessageCO = new ValidationMessageCO();
    List<String> errorMessages = new ArrayList<>();
    ex.getErrorMessages().forEach(fieldError -> errorMessages.add(fieldError.getDefaultMessage()));
    validationMessageCO.setValidationErrors(errorMessages);
    APIResponse<ValidationMessageCO> response = new APIResponse<>(
        FALSE, validationMessageCO.getValidationErrors().get(0), validationMessageCO);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
