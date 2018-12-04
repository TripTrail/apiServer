package com.company.application.security;

import static com.company.application.constants.Constant.ALL_PUBLIC_URL_PATTERN;
import static com.company.application.constants.Constant.ALL_URL_PATTERN;
import static com.company.application.constants.Constant.OAUTH_TOKEN_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableWebSecurity
@EnableResourceServer
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthProvider authProvider;

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean()
      throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .anyRequest().authenticated()
        .antMatchers(HttpMethod.OPTIONS, OAUTH_TOKEN_URL).permitAll();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers(ALL_PUBLIC_URL_PATTERN);
    web.ignoring().antMatchers(HttpMethod.OPTIONS, ALL_URL_PATTERN);
  }


}
