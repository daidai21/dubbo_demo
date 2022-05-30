package com.example.demo.client;

import com.example.demo.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/demo-client.xml");
        context.start();
        HelloService demoService = (HelloService) context.getBean("helloService");
        String hello = demoService.sayHello("world");
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println(hello);
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
}
