package com.example.demo.api;

import com.example.demo.dto.Request;
import com.example.demo.dto.Response;

public interface DemoService {

    Response<String> compute(Request request);

}
