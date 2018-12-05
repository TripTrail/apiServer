package com.company.application.controller;

import static com.company.application.constants.ControllerConstant.API_PUBLIC_BASE_URL;
import static com.company.application.constants.ControllerConstant.API_PUBLIC_USER_REGISTRATION_URL;

import com.company.application.co.APIResponse;
import com.company.application.co.RegistrationDetailsCO;
import com.company.application.exception.ValidationException;
import com.company.application.service.RegistrationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API_PUBLIC_BASE_URL)
public class PublicController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping(value = API_PUBLIC_USER_REGISTRATION_URL)
    public APIResponse registerNewUser(@RequestBody @Valid RegistrationDetailsCO registrationDetailsCO,
                                       BindingResult result) throws ValidationException {

        if (result.hasErrors()) {
            throw new ValidationException(result.getFieldErrors());
        }
        registrationService.registerNewUser(registrationDetailsCO);
        return new APIResponse<String>();
    }
}
