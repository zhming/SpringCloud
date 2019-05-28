package com.example.serviceribbon.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    private RestTemplate restTemplate;

    public HelloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

}
