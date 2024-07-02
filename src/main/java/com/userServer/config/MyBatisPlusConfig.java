package com.userServer.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.userServer.mapper") //扫描器
public class MyBatisPlusConfig { //配置类

}
