package com.mutistic.demo.eureka.consumer.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "DEMO-EUREKA-PRODUCER", path = "/demo/eureka/producer/hello")
public interface HelloFeignClient {

  @GetMapping(value = "/getHello?name={name}")
  String getHello(@PathVariable("name") String name);

  @PostMapping(value = "/postHello")
  JSONObject postHello(JSONObject params);

}
