package com.company.application.security;

import static com.company.application.constants.Constant.AUTH_EMAIL_INVAID;
import static com.company.application.constants.Constant.AUTH_EMAIL_MANDATORY;
import static com.company.application.constants.Constant.AUTH_PASSWORD_INVALID;
import static com.company.application.constants.Constant.AUTH_PASSWORD_MANDATORY;
import static com.company.application.constants.Constant.USER_AUTHORITY;

import com.company.application.config.MessageHelper;
import com.company.application.entity.UserDetail;
import com.company.application.exception.GenericException;
import com.company.application.repository.UserRepository;
import java.util.Arrays;
import java.util.Optional;
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

  @Autowired
  private MessageHelper messageHelper;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String email = Optional.ofNullable(authentication.getPrincipal())
        .orElseThrow(() -> new GenericException(messageHelper.getMessage(AUTH_EMAIL_MANDATORY)))
        .toString();
    String password = Optional.ofNullable(authentication.getCredentials())
        .orElseThrow(() -> new GenericException(messageHelper.getMessage(AUTH_PASSWORD_MANDATORY)))
        .toString();

    try {
      UserDetail userDetail = Optional.ofNullable(userRepository.findByEmailId(email))
          .orElseThrow(() -> new GenericException(messageHelper.getMessage(AUTH_EMAIL_INVAID)));

      if (!passwordEncoder.matches(password, userDetail.getPassword())) {
        throw new GenericException(messageHelper.getMessage(AUTH_PASSWORD_INVALID));
      }
      final UsernamePasswordAuthenticationToken token =
          new UsernamePasswordAuthenticationToken(userDetail.getUserId(), password,
              Arrays.asList(
                  new SimpleGrantedAuthority(USER_AUTHORITY)
              ));
      token.setDetails(userDetail);
      return token;

    } catch (OAuth2Exception e) {
      throw new GenericException(e.getMessage());
    }

  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
