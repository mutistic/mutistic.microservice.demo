package com.mutistic.demo.eureka.consumer.load;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestTemplate;

/**
 * 基于 LoadBalanced 的配置
 */
@Order(2)
@Configuration
public class LoadBalancedConfig {

  @Bean
  @LoadBalanced
  public RestTemplate loadRestTemplate() {
    return new RestTemplate();
  }

}
