package com.example.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${server.port}")
    private String port;


    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "zhming") String name){
        return "Hello " + name + " I am from port: " + port;
    }

}
