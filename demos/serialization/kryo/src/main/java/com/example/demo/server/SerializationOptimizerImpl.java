package com.example.demo.server;

import com.example.demo.dto.Request;
import com.example.demo.dto.Response;
import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class<?>> getSerializableClasses() {
        List<Class<?>> classes = new LinkedList<>();
        classes.add(Request.class);
        classes.add(Response.class);
        return classes;
    }
}
