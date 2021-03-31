package com.mutistic.demo.provider.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class WebAttribute {

  /**
   * 项目端口号
   */
  @Value("${server.port:8080}")
  private String port;
  /**
   * 项目基本路径
   */
  @Value("${server.servlet.context-path:/}")
  private String path;
  /**
   * 项目使用环境
   */
  @Value("${spring.profiles.active:dev}")
  private String active;
  /**
   * 项目名称
   */
  @Value("${spring.application.name:}")
  private String name;
  /**
   * 项目版本号
   */
  @Value("${spring.application.version:1.0}")
  private String version;
  /**
   * 项目描述
   */
  @Value("${spring.application.description:}")
  private String description;

  public String getUrlPath() {
    return "http://127.0.0.1:" + port + path;
  }

}
