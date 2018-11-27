package com.company.application.controller;

import com.company.application.co.APIResponse;
import com.company.application.co.RegistrationDetailsCO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/")
public class PublicController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public APIResponse signUp(@RequestBody RegistrationDetailsCO registrationDetailsCO){
        return new APIResponse();
    }
}
