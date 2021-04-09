package com.mutistic.demo.nacos.config.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.config.NacosConfigService;
import com.alibaba.nacos.common.task.NacosTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bootstrap.BootstrapApplicationListener;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
// 通过 Spring Cloud 原生注解 @RefreshScope 实现配置局部自动更新：
@RefreshScope
public class ConfigController {

  @Value("${test.user.name:}")
  private String name;
  @Value("${test.user.age:}")
  private String age;
  @Autowired
  private EnvironmentFunction environmentFunction;

  @RequestMapping("/getByRefreshScope")
  public JSONObject getByRefreshScope() {
    return new JSONObject().fluentPut("name", name).fluentPut("age", age);
  }

  @RequestMapping("/getByEnvironment")
  public JSONObject getByEnvironment() {
    Object name = environmentFunction.getPropertyValue("test.user.name");
    Object age = environmentFunction.getPropertyValue("test.user.age");
    return new JSONObject().fluentPut("name", name).fluentPut("age", age);
  }

}
