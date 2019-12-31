package com.atguigu.consumer.controller;

import com.atguigu.consumer.feign.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    private ProviderClient client;

    @GetMapping("hi")
    public String hi(){
        String msg = this.client.hello();
        return "hi consumer! " + msg;
    }
}
