package com.github.mawan94.dubboprovider.service.impl;


import com.github.mawan94.dubboapi.service.DemoService;
import com.alibaba.dubbo.config.annotation.Service;


@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
