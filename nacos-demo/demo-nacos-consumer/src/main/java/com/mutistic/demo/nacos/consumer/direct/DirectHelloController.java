package com.mutistic.demo.nacos.consumer.direct;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/direct/hello")
public class DirectHelloController {

  private RestTemplate restTemplate = new RestTemplate();

  @GetMapping("/testGet")
  public JSONObject testGet(String name) {
    String url = "http://127.0.0.1:12010/demo/nacos/producer/hello/getHello?name=%s";
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

  @PostMapping("/testPost")
  public JSONObject testPost(@RequestBody JSONObject params) {
    String url = "http://127.0.0.1:12010/demo/nacos/producer/hello/postHello";
    JSONObject result = restTemplate.postForObject(url, params, JSONObject.class);

    JSONObject resultJson = new JSONObject(true);
    resultJson.put("请求标题", "通过Http调用POST接口");
    resultJson.put("请求方式", "POST");
    resultJson.put("请求地址", url);
    resultJson.put("请求参数", params);
    resultJson.put("响应结果", result);
    log.info("调用结果: " + resultJson);
    return resultJson;
  }

}
