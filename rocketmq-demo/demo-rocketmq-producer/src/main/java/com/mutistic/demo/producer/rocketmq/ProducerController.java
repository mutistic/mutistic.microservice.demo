package com.mutistic.demo.producer.rocketmq;

import com.alibaba.fastjson.JSONObject;
import com.mutistic.demo.producer.common.WebAttribute;
import com.mutistic.demo.producer.config.RocketProducerSource;
import java.util.stream.IntStream;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
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
  @Autowired
  private RocketProducerSource rocketProducerSource;

  @GetMapping("/getHello")
  public String getHello(String name) {
    String result = name == null ? "NULL" : name + ", 成功调用 RocketMQ 生产者: " + webAttribute.getUrlPath() + "/hello/getHello";

    int size = NumberUtils.isParsable(name) ? NumberUtils.toInt(name) : 1;
    IntStream.range(0, size).parallel().forEach(index -> {
      MessageBuilder<?> builder = MessageBuilder.withPayload(index);
      builder.setHeader(RocketMQHeaders.TAGS, "getHello");
      builder.setHeader(RocketMQHeaders.KEYS, index);
      builder.setHeader("DELAY", "1");
      Message<?> message = builder.build();
      rocketProducerSource.outputString().send(message);
      System.out.println(result);
    });

    return result;
  }

  @PostMapping("/postHello")
  public JSONObject postHello(@RequestBody JSONObject params) {

    int size = params.getIntValue("size");
    if (size == 0) {
      size = 1;
    }
    IntStream.range(0, size).parallel().forEach(index -> {
      JSONObject result = new JSONObject(true);
      result.put("result", "成功调用 RocketMQ 生产者: " + webAttribute.getUrlPath() + "/hello/postHello");
      result.put("path", webAttribute.getUrlPath());
      result.put("index", index);
      result.put("params", params);

      MessageBuilder<?> builder = MessageBuilder.withPayload(result);
      builder.setHeader(RocketMQHeaders.TAGS, "postHello");
      builder.setHeader(RocketMQHeaders.KEYS, params.getString("name"));
      builder.setHeader("DELAY", "1");
      Message<?> message = builder.build();
      rocketProducerSource.outputObject().send(message);
      System.out.println(result);
    });

    return params;
  }

}
