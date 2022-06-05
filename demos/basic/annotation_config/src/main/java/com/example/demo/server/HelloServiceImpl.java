package com.example.demo.server;

import com.example.demo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;


@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
