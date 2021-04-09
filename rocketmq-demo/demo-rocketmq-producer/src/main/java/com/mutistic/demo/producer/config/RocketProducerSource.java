package com.mutistic.demo.producer.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * RocketMQ 生产者 消息通道
 */
public interface RocketProducerSource {

  @Output("output-string")
  MessageChannel outputString();

  @Output("output-object")
  MessageChannel outputObject();

}
