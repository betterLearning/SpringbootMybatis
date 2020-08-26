package com.it.demo.controller;

import com.it.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hell world";
    }

    @RequestMapping(value = "/empt")
    public Object getAllEmpt(){
        return service.getAll();
    }

}
