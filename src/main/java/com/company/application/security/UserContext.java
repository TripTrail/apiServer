package com.company.application.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserContext {

  public static UUID getCurrentUserId(TokenStore tokenStore){
    String token = ((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().
        getAuthentication().getDetails()).getTokenValue();
    return (UUID) tokenStore.readAuthentication(token).getPrincipal();
  }
}
