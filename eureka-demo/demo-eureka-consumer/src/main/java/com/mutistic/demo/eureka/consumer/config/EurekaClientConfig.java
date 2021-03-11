package com.mutistic.demo.eureka.consumer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
@Order(0)
@Configuration
// @EnableEurekaClient注解，标注该类是一个服务注册发现组件中的客户端组件。
@EnableDiscoveryClient
// 使用feign发现服务
@EnableFeignClients("com.mutistic.demo.eureka.consumer.feign")
public class EurekaClientConfig {

  @Value("${eureka.server.ip:}")
  private String serverIp;
  @Value("${eureka.server.port:}")
  private Integer serverPort;
  @Value("${eureka.server.path:}")
  private String serverPath;
  @Value("${eureka.server.eureka:}")
  private String serverEureka;

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
