package com.mutistic.demo.provider.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.mutistic.demo.api.DubboHelloRpc;
import com.mutistic.demo.provider.common.WebAttribute;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class DubboHelloRpcImpl implements DubboHelloRpc {

  @Autowired
  private WebAttribute webAttribute;

  @Override
  public String getHello(String name) {
    String result = name == null ? "NULL" : name;
    result = result + ", 成功调用 Dubbo+Nacos生产者具体实现 DubboHelloRpcImpl.getHello() 方法, 当前端口: "
        + webAttribute.getPort();
    System.out.println(result);
    return result;
  }

  @Override
  public JSONObject postHello(JSONObject params) {
    JSONObject result = new JSONObject(true);
    result.put("result", "成功调用 Dubbo+Nacos生产者  DubboHelloRpcImpl.postHello() 方法");
    result.put("prot", webAttribute.getPort());
    result.put("params", params);
    System.out.println(result);
    return result;
  }
}
