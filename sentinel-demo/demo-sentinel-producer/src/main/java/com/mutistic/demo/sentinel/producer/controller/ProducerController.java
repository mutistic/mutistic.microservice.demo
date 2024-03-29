package com.mutistic.demo.sentinel.producer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ProducerController {

  @Autowired
  private WebAttribute webAttribute;

  @GetMapping("/getHello")
  @SentinelResource(value = "/hello/getHello")
  public String getHello(String name) {
    String result = name == null ? "NULL" : name;
    result = result + ", 成功调用普通生产者 /hello/postHello 方法, 当前路径: "
        + webAttribute.getUrlPath();
    System.out.println(result);
    return result;
  }

  @PostMapping("/postHello")
  @SentinelResource(value = "/hello/postHello")
  public JSONObject postHello(@RequestBody JSONObject params) {
    JSONObject result = new JSONObject(true);
    result.put("result", "成功调用普通生产者 /hello/postHello 方法");
    result.put("path", webAttribute.getUrlPath());
    result.put("params", params);
    System.out.println(result);
    return result;
  }

}
