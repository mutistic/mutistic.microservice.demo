package com.mutistic.demo.eureka.consumer.load;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/load/hello")
public class LoadConsumerController {

  @Autowired
  private RestTemplate loadRestTemplate;

  @GetMapping("/testGet")
  public JSONObject testGet(String name) {
    String url = "http://DEMO-EUREKA-PRODUCER/demo/eureka/producer/hello/getHello?name=%s";
    url = String.format(url, name);
    String result = loadRestTemplate.getForObject(url, String.class);

    JSONObject resultJson = new JSONObject(true);
    resultJson.put("请求标题", "通过 LoadBalanced 调用GET接口");
    resultJson.put("请求方式", "GET");
    resultJson.put("请求地址", "非直接指定");
    resultJson.put("请求参数", name);
    resultJson.put("响应结果", result);
    resultJson.put("LoadBalanced请求地址", url);
    resultJson.put("Eureka生产者名称(不区分大小写)", "DEMO-EUREKA-PRODUCER");
    resultJson.put("Eureka生产者路径", "/demo/eureka/producer/hello");
    resultJson.put("Eureka生产者方法", "/getHello?name={name}");
    log.info("调用结果: " + resultJson);
    return resultJson;
  }

  @PostMapping("/testPost")
  public JSONObject testPost(@RequestBody JSONObject params) {
    String url = "http://demo-eureka-producer/demo/eureka/producer/hello/postHello";
    JSONObject result = loadRestTemplate.postForObject(url, params, JSONObject.class);

    JSONObject resultJson = new JSONObject(true);
    resultJson.put("请求标题", "通过 LoadBalanced 调用POST接口");
    resultJson.put("请求方式", "POST");
    resultJson.put("请求地址", "非直接指定");
    resultJson.put("请求参数", params);
    resultJson.put("响应结果", result);
    resultJson.put("LoadBalanced请求地址", url);
    resultJson.put("Eureka生产者名称(不区分大小写)", "demo-eureka-producer");
    resultJson.put("Eureka生产者路径", "/demo/eureka/producer/hello");
    resultJson.put("Eureka生产者方法", "/postHello");

    log.info("调用结果: " + resultJson);
    return resultJson;
  }

}
