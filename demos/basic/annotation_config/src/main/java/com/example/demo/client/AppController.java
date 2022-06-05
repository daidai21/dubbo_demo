package com.example.demo.client;


import com.example.demo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@DubboComponentScan(basePackages = "com.example.demo.client")
public class AppController {
    @Autowired
    private HelloService helloService1;

    @DubboReference
    private HelloService helloService2;

    // http://localhost:8082/hello
    @GetMapping(value = "/hello")
    public void hello() {
        System.out.println("====================");

        String result1 = helloService1.sayHello("world");
        System.out.println("@Autowired: " + result1);

        String result2 = helloService2.sayHello("world");
        System.out.println("@DubboReference: " + result2);

        System.out.println("====================");

    }
}
