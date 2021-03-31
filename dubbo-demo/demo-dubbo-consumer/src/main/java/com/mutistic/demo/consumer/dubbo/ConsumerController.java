package com.mutistic.demo.consumer.dubbo;

import com.alibaba.fastjson.JSONObject;
import com.mutistic.demo.api.DubboHelloRpc;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello")
public class ConsumerController {

  @DubboReference
  private DubboHelloRpc dubboHelloRpc;

  @GetMapping("/testGet")
  public JSONObject testGet(String name) {
    String result = dubboHelloRpc.getHello(name);

    JSONObject resultJson = new JSONObject(true);
    resultJson.put("请求标题", "通过 Dubbo+Nacos 调用RPC接口");
    resultJson.put("请求参数", name);
    resultJson.put("响应结果", result);
    resultJson.put("Dubbo注册中心", "Nacos");
    resultJson.put("Dubbo服务提供者", dubboHelloRpc.getClass().getName());
    resultJson.put("Dubbo服务调用方法", "DubboHelloRpc.getHello()");
    resultJson.put("Nacos生产者名称", "providers:com.mutistic.demo.api.DubboHelloRpc");
    resultJson.put("Nacos生产者服务信息", JSONObject.parseObject("{\"side\":\"provider\",\"methods\":\"postHello,getHello\",\"release\":\"2.7.8\",\"deprecated\":\"false\",\"dubbo\":\"2.0.2\",\"pid\":\"29632\",\"interface\":\"com.mutistic.demo.api.DubboHelloRpc\",\"generic\":\"false\",\"path\":\"com.mutistic.demo.api.DubboHelloRpc\",\"protocol\":\"dubbo\",\"metadata-type\":\"remote\",\"application\":\"demo-dubbo-provider-dubbo\",\"dynamic\":\"true\",\"category\":\"providers\",\"anyhost\":\"true\",\"timestamp\":\"1617185645754\"}"));
    log.info("调用结果: " + resultJson);
    return resultJson;
  }

  @PostMapping("/testPost")
  public JSONObject testPost(@RequestBody JSONObject params) {
    JSONObject result = dubboHelloRpc.postHello(params);

    JSONObject resultJson = new JSONObject(true);
    resultJson.put("请求标题", "通过 Dubbo+Nacos 调用RPC接口");
    resultJson.put("请求参数", params);
    resultJson.put("响应结果", result);
    resultJson.put("Dubbo注册中心", "Nacos");
    resultJson.put("Dubbo服务提供者", dubboHelloRpc.getClass().getName());
    resultJson.put("Dubbo服务调用方法", "DubboHelloRpc.postHello()");
    resultJson.put("Nacos生产者名称", "providers:com.mutistic.demo.api.DubboHelloRpc");
    resultJson.put("Nacos生产者服务信息", JSONObject.parseObject("{\"side\":\"provider\",\"methods\":\"postHello,getHello\",\"release\":\"2.7.8\",\"deprecated\":\"false\",\"dubbo\":\"2.0.2\",\"pid\":\"29632\",\"interface\":\"com.mutistic.demo.api.DubboHelloRpc\",\"generic\":\"false\",\"path\":\"com.mutistic.demo.api.DubboHelloRpc\",\"protocol\":\"dubbo\",\"metadata-type\":\"remote\",\"application\":\"demo-dubbo-provider-dubbo\",\"dynamic\":\"true\",\"category\":\"providers\",\"anyhost\":\"true\",\"timestamp\":\"1617185645754\"}"));

    log.info("调用结果: " + resultJson);
    return resultJson;
  }

}
