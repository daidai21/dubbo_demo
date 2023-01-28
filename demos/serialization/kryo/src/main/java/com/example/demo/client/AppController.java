package com.example.demo.client;


import com.example.demo.api.DemoService;
import com.example.demo.dto.Request;
import com.example.demo.dto.Response;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@DubboComponentScan(basePackages = "com.example.demo.client")
public class AppController {

    @Autowired
    private DemoService demoService;

    // http://localhost:8082/demo
    @GetMapping(value = "/demo")
    public void sync() {
        System.out.println("====================");

        Response<String> response = demoService.compute(new Request(1L, "tom"));

        System.out.println(response);

        System.out.println("====================");
    }

}
