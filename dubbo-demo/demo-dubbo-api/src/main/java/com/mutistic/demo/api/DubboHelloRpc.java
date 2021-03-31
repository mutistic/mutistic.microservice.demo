package com.mutistic.demo.api;

import com.alibaba.fastjson.JSONObject;

public interface DubboHelloRpc {

  String getHello(String name);

  JSONObject postHello(JSONObject params);

}
