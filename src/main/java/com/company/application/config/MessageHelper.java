package com.company.application.config;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {

  @Autowired
  private MessageSource messageSource;

  public String getMessage(String key){
    return messageSource.getMessage(key, new Object[]{}, Locale.getDefault());
  }

}
