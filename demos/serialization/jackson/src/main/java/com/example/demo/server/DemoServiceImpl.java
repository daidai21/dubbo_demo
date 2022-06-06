package com.example.demo.server;

import com.example.demo.api.DemoService;
import com.example.demo.dto.Request;
import com.example.demo.dto.Response;
import org.apache.dubbo.config.annotation.DubboService;


@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public Response<String> compute(Request request) {
        System.out.println("request: " + request);

        Response<String> response = new Response<>();
        response.setSucceed(true);
        response.setErrorCode(null);
        response.setErrorMessage("null");
        response.setErrorMessage(request.getName());
        return response;
    }
}
