package com.example.demo.client;

import com.example.demo.api.HelloService;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DubboComponentScan(basePackages = "com.example.demo.client")
public class AppController {
    @Autowired
    private HelloService helloService;

    // http://localhost:8082/hello
    @GetMapping(value = "/hello")
    public void hello() {
        System.out.println("====================");

        String result = helloService.sayHello("world");
        System.out.println("@Autowired: " + result);

        System.out.println("====================");

    }
}
