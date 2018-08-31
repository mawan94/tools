package com.github.mawan94.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProviderApplication {
    @Autowired
    private Producer producer;

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }


    @GetMapping("/hi")
    public void hi() {
        producer.sendMsg();
    }
}
