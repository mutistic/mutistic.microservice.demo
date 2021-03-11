package com.mutistic.demo.eureka.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.mutistic.demo.eureka.consumer.feign.HelloFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("/testGet")
public class ConsumerGetController {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private HelloFeignClient helloFeignClient;

  @GetMapping("/testDirect")
  public JSONObject testDirect(String name) {
    String url = "http://127.0.0.1:12000/demo/eureka/producer/hello/getHello?name=%s";
    url = String.format(url, name);
    String result = restTemplate.getForObject(url, String.class);

    JSONObject resultJson = new JSONObject(true);
    resultJson.put("请求标题", "通过Http调用GET接口");
    resultJson.put("请求方式", "GET");
    resultJson.put("请求地址", url);
    resultJson.put("请求参数", name);
    resultJson.put("响应结果", result);
    log.info("调用结果: " + resultJson);
    return resultJson;
  }

  @GetMapping("/testConsumer")
  public JSONObject testConsumer(String name) {
    String result = helloFeignClient.getHello(name);

    JSONObject resultJson = new JSONObject(true);
    resultJson.put("请求标题", "通过Feign调用GET接口");
    resultJson.put("请求方式", "GET");
    resultJson.put("请求地址", "非直接指定");
    resultJson.put("请求参数", name);
    resultJson.put("响应结果", result);
    resultJson.put("Eureka生产者名称", "DEMO-EUREKA-PRODUCER");
    resultJson.put("Eureka生产者路径", "/demo/eureka/producer/hello");
    resultJson.put("Eureka生产者方法", "/getHello?name={name}");
    log.info("调用结果: " + resultJson);
    return resultJson;
  }

}
