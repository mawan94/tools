package com.github.mawan94.websocketdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
@Controller
public class WebsocketDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebsocketDemoApplication.class, args);
    }


    @GetMapping("/hello")
    public String index(){
        return "index";
    }
}
