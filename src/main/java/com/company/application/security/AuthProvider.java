package com.company.application.security;

import com.company.application.entity.UserDetail;
import com.company.application.exception.GenericException;
import com.company.application.repository.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;

@Component
public class AuthProvider implements AuthenticationProvider {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String email = authentication.getPrincipal() != null ? authentication.getPrincipal().toString(): null;
    String password = authentication.getCredentials() != null ? authentication.getCredentials().toString() : null;

    UserDetail userDetail = null;
    try {
      if(email == null || password == null || email.length() == 0 || password.length() == 0) {
        throw new GenericException("Email Id or Password in Missing!");
      }else{
        userDetail = userRepository.findByEmailId(email);
        if(userDetail == null){
          throw new GenericException("Email Password Mismatch");
        }else {
          if(!passwordEncoder.matches(password, userDetail.getPassword())){
            throw new GenericException("Invalid Password");
          }
          final UsernamePasswordAuthenticationToken token =
              new UsernamePasswordAuthenticationToken(userDetail.getUserId(), password,
                  Arrays.asList(
                      new SimpleGrantedAuthority("USER")
                  ));
          token.setDetails(userDetail);
          return token;
        }
      }

    }catch(OAuth2Exception e){
      throw new GenericException(e.getMessage());
    }

  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
