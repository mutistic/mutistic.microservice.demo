package com.mutistic.demo.nacos.producer.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * nacos 账号密码 工具类
 */
public class NacosPasswordUtil {

  public static void main(String[] args) {
    String username = "mutisitc";
    String encodePassword = generateEncodePassword("mutisitc");
    generateUserSql(username, encodePassword);

    String rule = "ROLE_ADMIN";
    generateRuleSql(username, rule);
  }

  /**
   * 生成 nacos 加密密码
   * @param password 明文密码
   * @return 加密密码
   */
  public static String generateEncodePassword(String password) {
    return new BCryptPasswordEncoder().encode(password);
  }

  /**
   * 生成 user sql
   * @param username 用户名
   * @param password 加密密码
   */
  public static void generateUserSql(String username, String password) {
    String sql = "INSERT INTO users (username, password, enabled) VALUES ('%s', '%s', 1);";
    sql = String.format(sql, username, password);
    System.out.println(sql);
  }

  /**
   * 生成 rule sql
   * @param username 用户名
   * @param rule 角色
   */
  public static void generateRuleSql(String username, String rule) {
    String sql = "INSERT INTO roles (username, role) VALUES ('%s', '%s');";
    sql = String.format(sql, username, rule);
    System.out.println(sql);
  }

}
