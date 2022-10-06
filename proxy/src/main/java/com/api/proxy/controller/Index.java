package com.api.proxy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    @GetMapping("/api-proxy")
    public String getHelloWorld ()
    {
        return "Api Proxy Run";
    }
}