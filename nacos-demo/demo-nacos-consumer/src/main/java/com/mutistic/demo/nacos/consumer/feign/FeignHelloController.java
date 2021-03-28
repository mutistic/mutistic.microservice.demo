package com.mutistic.demo.nacos.consumer.feign;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("/feign/hello")
public class FeignHelloController {

  @Autowired
  private HelloFeignClient helloFeignClient;

  @GetMapping("/testGet")
  public JSONObject testGet(String name) {
    String result = helloFeignClient.getHello(name);

    JSONObject resultJson = new JSONObject(true);
    resultJson.put("请求标题", "通过 Feign+Ribbon 调用GET接口");
    resultJson.put("请求方式", "GET");
    resultJson.put("请求地址", "非直接指定");
    resultJson.put("请求参数", name);
    resultJson.put("响应结果", result);
    resultJson.put("Nacos生产者名称(区分大小写)", "demo-nacos-producer");
    resultJson.put("Nacos生产者路径", "/demo/nacos/producer/hello");
    resultJson.put("Nacos生产者方法", "/getHello?name={name}");
    log.info("调用结果: " + resultJson);
    return resultJson;
  }

  @PostMapping("/testPost")
  public JSONObject testPost(@RequestBody JSONObject params) {
    JSONObject result = helloFeignClient.postHello(params);

    JSONObject resultJson = new JSONObject(true);
    resultJson.put("请求标题", "通过 Feign+Ribbon 调用POST接口");
    resultJson.put("请求方式", "POST");
    resultJson.put("请求地址", "非直接指定");
    resultJson.put("请求参数", params);
    resultJson.put("响应结果", result);
    resultJson.put("Nacos生产者名称(区分大小写)", "demo-nacos-producer");
    resultJson.put("Nacos生产者路径", "/demo/nacos/producer/hello");
    resultJson.put("Nacos生产者方法", "/postHello");

    log.info("调用结果: " + resultJson);
    return resultJson;
  }

}
