package com.example.demo.client;


import com.example.demo.api.Consts;
import com.example.demo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@DubboComponentScan(basePackages = "com.example.demo.client")
public class AppController {
    @DubboReference
    private HelloService helloService;

    // http://localhost:8082/hello
    @GetMapping(value = "/hello")
    public void hello(@RequestParam("name") String traceName) {
        System.out.println("====================");

        RpcContext.getContext().setAttachment(Consts.TraceName, traceName);
        String result = helloService.sayHello("world");
        System.out.println(result);

        System.out.println("====================");

    }
}
