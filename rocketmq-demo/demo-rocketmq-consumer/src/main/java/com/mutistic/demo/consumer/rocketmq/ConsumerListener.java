package com.mutistic.demo.consumer.rocketmq;

import com.alibaba.fastjson.JSONObject;
import com.mutistic.demo.consumer.common.WebAttribute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerListener {

  @Autowired
  private WebAttribute webAttribute;

  @StreamListener("input-string")
  public void receiveInputStringByGetHello(String receiveMsg) {
    JSONObject resultJson = new JSONObject(true);
    resultJson.put("标题", "通过 RocketMQ 消费消息");
    resultJson.put("NameServer", "127.0.0.1:9876");
    resultJson.put("StreamListener", "input-string");
    resultJson.put("Group", "group-rocketmq-string");
    resultJson.put("ContentType", "application/json");
    resultJson.put("Topic", "topic-rocketmq-string");
    resultJson.put("Tag", "getHello");
    resultJson.put("Message", receiveMsg);
    resultJson.put("消费者", webAttribute.getUrlPath());
    System.out.println(resultJson);
  }

  @StreamListener("input-object")
  public void receiveInputStringByPostHello(JSONObject receiveMsg) {
    JSONObject resultJson = new JSONObject(true);
    resultJson.put("标题", "通过 RocketMQ 消费消息");
    resultJson.put("NameServer", "127.0.0.1:9876");
    resultJson.put("StreamListener", "input-object");
    resultJson.put("Group", "group-rocketmq-object");
    resultJson.put("ContentType", "application/json");
    resultJson.put("Topic", "topic-rocketmq-object");
    resultJson.put("Tag", "postHello");
    resultJson.put("Message", receiveMsg);
    resultJson.put("消费者", webAttribute.getUrlPath());
    System.out.println(resultJson);
  }

}
