package com.github.mawan94.dubboconsumer.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.mawan94.dubboapi.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConsumerController {

    @Reference(version = "1.0.0")
    private DemoService demoService;

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable("name") String name) {
        return demoService.sayHello(name);
    }

}
