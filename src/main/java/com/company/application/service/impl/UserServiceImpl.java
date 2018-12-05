package com.company.application.service.impl;

import com.company.application.co.UserDetailCO;
import com.company.application.security.UserContext;
import com.company.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private TokenStore tokenStore;

  @Override
  public UserDetailCO getUserProfile() {
    String userId = UserContext.getCurrentUserId(tokenStore);

    return null;
  }
}
