package com.company.application.service.impl;

import com.company.application.co.UserDetailCO;
import com.company.application.entity.UserDetail;
import com.company.application.repository.UserRepository;
import com.company.application.security.UserContext;
import com.company.application.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private TokenStore tokenStore;

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetailCO getUserProfile() {
    UUID userId = UserContext.getCurrentUserId(tokenStore);
    UserDetail userDetail = userRepository.findOne(userId);
    UserDetailCO userDetailCO = new UserDetailCO();
    BeanUtils.copyProperties(userDetail, userDetailCO);
    return userDetailCO;
  }
}
