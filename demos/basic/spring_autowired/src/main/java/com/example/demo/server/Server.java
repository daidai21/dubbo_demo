package com.example.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
}
