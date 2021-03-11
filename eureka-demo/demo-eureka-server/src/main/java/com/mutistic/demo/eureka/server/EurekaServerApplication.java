package com.mutistic.demo.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// @EnableEurekaServer 标注该类是一个eureka的服务注册中心类
@EnableEurekaServer
// @SpringBootApplication SpringBoot启动类
@SpringBootApplication
public class EurekaServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaServerApplication.class, args);
  }

}
