package com.company.application.security;

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
        .antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers( "/api/public/**");
    web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
  }


}
