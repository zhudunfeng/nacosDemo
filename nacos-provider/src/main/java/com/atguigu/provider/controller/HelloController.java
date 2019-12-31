package com.atguigu.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RefreshScope // 动态加载配置
public class HelloController {

    @Value("${myName}")
    private String myName;

    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${redis.url}")
    private String redisUrl;

    @GetMapping("hello")
    public String hello(HttpServletRequest request){
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL().toString());
        return "hello provider! " + myName + ", jdbcUrl = " + jdbcUrl + ", redisUrl = " + redisUrl;
    }
}
