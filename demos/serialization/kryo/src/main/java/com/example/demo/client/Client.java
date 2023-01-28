package com.example.demo.client;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;

@SpringBootApplication
@ImportResource({"classpath:/spring/demo-client.xml"})
public class Client {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Client.class);
        app.setDefaultProperties(new HashMap<String, Object>() {{
            put("server.port", "8082");
        }});
        app.run(args);


    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.example.demo.client")
//    @PropertySource("classpath:/spring/demo-client.xml")
    @ComponentScan(value = {"com.example.demo.client"})
    static public class ConsumerConfiguration {

    }

}
