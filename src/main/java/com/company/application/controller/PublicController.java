package com.company.application.controller;

import com.company.application.co.APIResponse;
import com.company.application.co.RegistrationDetailsCO;
import com.company.application.exception.ValidationException;
import com.company.application.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.company.application.constants.ControllerConstant.API_BASE_PUBLIC_URL;
import static com.company.application.constants.ControllerConstant.API_USER_REGISTRATION_URL;

@RestController
@RequestMapping(API_BASE_PUBLIC_URL)
public class PublicController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = API_USER_REGISTRATION_URL, method = RequestMethod.POST)
    public APIResponse registerNewUser(@RequestBody @Valid RegistrationDetailsCO registrationDetailsCO,
                                       BindingResult result) throws ValidationException {
        if (result.hasErrors()) {
            throw new ValidationException(result.getFieldErrors());
        }
        registrationService.registerNewUser(registrationDetailsCO);
        return new APIResponse<String>();
    }
}
