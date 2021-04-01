package com.mutistic.demo.consumer.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RocketConsumerSource {

  @Input("input-string")
  SubscribableChannel inputString();

  @Input("input-object")
  SubscribableChannel inputObject();

}
