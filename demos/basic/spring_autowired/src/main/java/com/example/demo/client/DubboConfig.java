package com.example.demo.client;

import com.example.demo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.example.demo.client")
@PropertySource("classpath:/spring/client.properties")
@ComponentScan(value = {"com.example.demo.client"})
public class DubboConfig {
    @DubboReference
    private HelloService helloService;
}
