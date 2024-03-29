package com.mutistic.demo.eureka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaProducerApplication.class, args);
  }

}
