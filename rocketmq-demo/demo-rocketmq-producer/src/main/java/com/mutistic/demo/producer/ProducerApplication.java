package com.mutistic.demo.producer;

import com.mutistic.demo.producer.config.RocketProducerSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
// 表示绑定配置文件中名称为output的消息通道
@EnableBinding({RocketProducerSource.class})
public class ProducerApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProducerApplication.class, args);
  }

}
