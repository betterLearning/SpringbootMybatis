package com.it.demo.controller;

import com.it.demo.domain.Empt;
import com.it.demo.dto.QuerySingleEmptParam;
import com.it.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
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

    @PostMapping(value = "/querySingleEmpt")
    public Empt querySingleEmpt(@RequestBody @Valid QuerySingleEmptParam param) {
        Empt empt = service.getSingleEmpt(param);
        return empt;
    }


}
