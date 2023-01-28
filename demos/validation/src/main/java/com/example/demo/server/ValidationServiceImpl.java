package com.example.demo.server;

import com.example.demo.api.ParamDTO;
import com.example.demo.api.ValidationService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(validation = "true")
public class ValidationServiceImpl implements ValidationService {
    @Override
    public void search(ParamDTO param) {
        System.out.println("ValidationService.search  " + param.toString());
    }
}
