package com.example.demo.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class Server {
    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/demo-server.xml");
        context.start();

        System.out.println("dubbo service started");

        new CountDownLatch(1).await();

    }
}
