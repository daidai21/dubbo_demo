package com.example.demo.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;

@SpringBootApplication
public class Server {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Server.class);
        app.setDefaultProperties(new HashMap<String, Object>() {{
            put("server.port", "8081");
        }});
        app.run(args);

    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.example.demo.server")
    @PropertySource("classpath:/spring/server.properties")
    static class ProviderConfiguration {

    }
}
