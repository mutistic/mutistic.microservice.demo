package com.mutistic.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProviderApplication.class, args);
  }

}
