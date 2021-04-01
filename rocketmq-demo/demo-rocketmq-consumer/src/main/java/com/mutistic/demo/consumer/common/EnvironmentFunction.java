package com.mutistic.demo.consumer.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentFunction {

  @Autowired
  private ConfigurableEnvironment configurableEnvironment;

  public Object getPropertyValue(String propertyName){
    return configurableEnvironment.getProperty(propertyName);
  }

}
