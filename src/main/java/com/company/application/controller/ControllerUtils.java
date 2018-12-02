package com.company.application.controller;

import com.company.application.co.ValidationMessageCO;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class ControllerUtils {

    public static ValidationMessageCO checkValidationErrors(BindingResult result){
        ValidationMessageCO validationMessageCO = new ValidationMessageCO();
        List<String> errorMessages = new ArrayList<>();
        result.getFieldErrors().forEach(fieldError -> {
            errorMessages.add(fieldError.getDefaultMessage());
        });
        validationMessageCO.setValidationErrors(errorMessages);
        return validationMessageCO;
    }
}
