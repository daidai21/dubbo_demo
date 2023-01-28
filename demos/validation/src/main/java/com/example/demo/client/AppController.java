package com.example.demo.client;


import com.example.demo.api.ParamDTO;
import com.example.demo.api.ValidationService;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;


@RestController
@Log4j2
@DubboComponentScan(basePackages = "com.example.demo.client")
public class AppController {
    @DubboReference(validation = "true") // validation不为true就不会生效
    private ValidationService validationService;

    // http://localhost:8082/hello
    @GetMapping(value = "/basic")
    public void basic(@RequestParam("name") String name,
                      @RequestParam("age") Integer age) {
        System.out.println("====================  basic");

        validationService.search(ParamDTO.builder()
                .name(name)
                .age(age)
                .build());

        System.out.println("====================");

    }

    @GetMapping(value = "/recover")
    public void recover(@RequestParam("name") String name,
                        @RequestParam("age") Integer age) {
        System.out.println("====================  recover");

        try {
            validationService.search(ParamDTO.builder()
                    .name(name)
                    .age(age)
                    .build());

        } catch (ValidationException e) {
            log.error(e);
        }
    }

}
