package com.example.demo.server;

import com.example.demo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception ignored) {
        }
        return "hello, " + name;
    }

    // FIXME: 控制台admin 展示有问题
    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        CompletableFuture<String> future = new CompletableFuture<String>();
        future.complete(sayHello(name));
        return future;
    }
}
