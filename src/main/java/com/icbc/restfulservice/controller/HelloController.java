package com.icbc.restfulservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(path = "/hello",produces = "text/plain")
    public String hello() {
        return "hello";
    }
}