package com.example.demo.api;

import java.util.concurrent.CompletableFuture;

public interface HelloService {
    String sayHello(String name);

    CompletableFuture<String> sayHelloAsync(String name);
}
