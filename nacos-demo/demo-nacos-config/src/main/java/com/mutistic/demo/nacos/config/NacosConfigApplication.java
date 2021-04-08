package com.mutistic.demo.nacos.config;

import java.util.concurrent.TimeUnit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;

// @SpringCloudApplication
@SpringBootApplication
@EnableDiscoveryClient
// 通过 Spring Cloud 原生注解 @RefreshScope 实现配置自动更新：
@RefreshScope
public class NacosConfigApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigApplication.class, args);
  }

}
