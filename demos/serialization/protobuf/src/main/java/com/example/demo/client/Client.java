package com.example.demo.client;

import com.example.demo.gen.DemoServiceProto;
import com.example.demo.gen.HelloReply;
import com.example.demo.gen.HelloRequest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        // TODO

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
        DemoServiceProto demoService = context.getBean("demoServiceProto", DemoServiceProto.class);
        HelloRequest request = HelloRequest.newBuilder().setName("Hello").build();
        HelloReply reply = demoService.sayHello(request);
        System.out.println("result: " + reply.getMessage());
    }
}

