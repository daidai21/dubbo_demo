package com.example.demo.client;


import com.example.demo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@RestController
@DubboComponentScan(basePackages = "com.example.demo.client")
public class AppController {

    @DubboReference
    private HelloService helloService;

    @DubboReference(async = true)
    private HelloService helloService2;

    // http://localhost:8082/sync
    @GetMapping(value = "/sync")
    public void sync() {
        System.out.println("====================");
        long now = System.currentTimeMillis();

        for (int i = 0; i < 5; ++i) {
            System.out.println(helloService.sayHello("world   sync"));
        }

        System.out.println("Cost: " + (System.currentTimeMillis() - now) + "ms");
        System.out.println("====================");
    }

    /**
     * 使用 RpcContext
     */
    // http://localhost:8082/async
    @GetMapping(value = "/async")
    public void async() {
        System.out.println("====================");
        long now = System.currentTimeMillis();

        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            System.out.println("send: " + "world   async");
            helloService2.sayHello("world   async");
            Future<String> future = RpcContext.getContext().getFuture();
            list.add(future);
        }

        for (int i = 0; i < list.size(); ++i) {
            try {
                System.out.println("get: " + list.get(i).get());
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }

        System.out.println("Cost: " + (System.currentTimeMillis() - now) + "ms");
        System.out.println("====================");
    }

    /**
     * 使用 CompletableFuture 签名的接口
     */
    // http://localhost:8082/async_future
    @GetMapping(value = "/async_future")
    public void asyncFuture() {
        System.out.println("====================");
        long now = System.currentTimeMillis();

        List<CompletableFuture<String>> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            System.out.println("send: " + "world   async future");
            list.add(helloService2.sayHelloAsync("world   async"));
        }

        for (int i = 0; i < list.size(); ++i) {
            try {
                System.out.println("get: " + list.get(i).get());
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }

        System.out.println("Cost: " + (System.currentTimeMillis() - now) + "ms");
        System.out.println("====================");
    }
}
