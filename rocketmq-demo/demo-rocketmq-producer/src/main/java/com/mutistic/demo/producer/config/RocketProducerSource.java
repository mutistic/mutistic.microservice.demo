package com.mutistic.demo.producer.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RocketProducerSource {

  @Output("output-string")
  MessageChannel outputString();

  @Output("output-object")
  MessageChannel outputObject();

}
