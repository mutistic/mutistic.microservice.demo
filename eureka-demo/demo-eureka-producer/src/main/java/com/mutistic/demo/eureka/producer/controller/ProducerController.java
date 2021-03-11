package com.mutistic.demo.eureka.producer.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @EnableEurekaClient注解，标注该类是一个服务注册发现组件中的客户端组件。
@EnableEurekaClient
@RestController
@RequestMapping("/hello")
public class ProducerController {

  @GetMapping("/getHello")
  public String getHello(String name) {
    String result = name == null ? "NULL" : name;
    result = result + ", 成功调用 Eureka demo producer 服务生产者的 /hello/getHello 方法";
    System.out.println(result);
    return result;
  }

  @PostMapping("/postHello")
  public JSONObject postHello(@RequestBody JSONObject params) {
    JSONObject result = new JSONObject(true);
    result.put("result", "成功调用 Eureka demo producer 服务生产者 /hello/postHello 方法");
    result.put("params", params);
    System.out.println(result);
    return result;
  }

}
