package com.mutistic.demo.api;

import com.alibaba.fastjson.JSONObject;

/**
 * 定义 api 接口及方法
 */
public interface DubboHelloRpc {

  String getHello(String name);

  JSONObject postHello(JSONObject params);

}
