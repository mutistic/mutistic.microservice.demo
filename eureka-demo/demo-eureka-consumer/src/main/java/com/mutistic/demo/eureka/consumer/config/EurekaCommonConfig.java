package com.mutistic.demo.eureka.consumer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * eureka 通用配置
 */
@Getter
@Setter
@Order(0)
@Configuration
public class EurekaCommonConfig {

  @Value("${eureka.server.ip:}")
  private String serverIp;
  @Value("${eureka.server.port:}")
  private Integer serverPort;
  @Value("${eureka.server.path:}")
  private String serverPath;
  @Value("${eureka.server.eureka:}")
  private String serverEureka;

}
