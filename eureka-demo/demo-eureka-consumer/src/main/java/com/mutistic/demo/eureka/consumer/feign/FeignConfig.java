package com.mutistic.demo.eureka.consumer.feign;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 基于 feign 的配置
 * <p> https://github.com/Netflix/ribbon/wiki/Working-with-load-balancers#components-of-load-balancer
 */
@Order(1)
@Configuration
// @EnableEurekaClient注解，标注该类是一个服务注册发现组件中的客户端组件。
@EnableDiscoveryClient
// 使用feign发现服务
@EnableFeignClients("com.mutistic.demo.eureka.consumer.*")
public class FeignConfig {

}
