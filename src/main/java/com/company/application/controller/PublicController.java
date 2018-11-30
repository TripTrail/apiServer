package com.company.application.controller;

import static com.company.application.constants.ControllerConstant.*;
import com.company.application.co.APIResponse;
import com.company.application.co.RegistrationDetailsCO;
import com.company.application.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(API_BASE_PUBLIC_URL)
public class PublicController {

    @Autowired
    private PublicService publicService;

    @RequestMapping(value = API_USER_REGISTRATION_URL, method = RequestMethod.POST)
    public APIResponse signUp(@RequestBody @Valid RegistrationDetailsCO registrationDetailsCO, BindingResult result){
        if(result.hasErrors()){

        }
        publicService.registerNewUser(registrationDetailsCO);
        return new APIResponse(null);
    }
}
