package com.company.application.controller;

import static com.company.application.constants.ControllerConstant.*;

import com.company.application.co.APIResponse;
import com.company.application.co.UserDetailCO;
import com.company.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API_USER_BASE_URL)
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(API_USER_PROFILE_URL)
  public APIResponse<UserDetailCO> getUserProfile(){
    UserDetailCO userDetailCO = userService.getUserProfile();
    return new APIResponse<>(userDetailCO);
  }

}
