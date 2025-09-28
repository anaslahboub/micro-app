package com.anas.customerservice.controllers;

import com.anas.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestControllers {

    @Value("${global.params.p1}")
    int p1;
    @Value("${global.params.p2}")
    int p2;
    @Value("${customer.params.x}")
    int x;
    @Value("${customer.params.y}")
    int y;

    @Autowired
    GlobalConfig global;


    @GetMapping("/testConfig")
    public Map<String,Integer> configTest(){
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);
    }
    @GetMapping("/globalConfig")
    public GlobalConfig getGlobal() {
        return global;
    }
}
