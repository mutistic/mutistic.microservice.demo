package com.mutistic.demo.consumer.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * RocketMQ 消费者 消息通道
 */
public interface RocketConsumerSource {

  @Input("input-string")
  SubscribableChannel inputString();

  @Input("input-object")
  SubscribableChannel inputObject();

}
