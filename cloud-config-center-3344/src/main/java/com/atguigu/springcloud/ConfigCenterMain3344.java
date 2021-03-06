package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 全部通知：curl -X POST "http://localhost:3344/actuator/bus-refresh"
 * 第二种设计方式刷新3344服务端利用消息插件全部通知
 * 精确通知：curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"
 * 精确通知config-client:3355这个config-client是服务名3355是端口号用于通知固定的一个
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
