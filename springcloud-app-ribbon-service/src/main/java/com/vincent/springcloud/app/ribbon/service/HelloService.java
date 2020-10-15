package com.vincent.springcloud.app.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String sayHello(final String uname) {
        return restTemplate.getForObject("http://SPRINGCLOUD-APP-EUREKA-CLIENT/hi?uname="+uname, String.class);
    }
}
