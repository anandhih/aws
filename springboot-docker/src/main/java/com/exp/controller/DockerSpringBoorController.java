package com.exp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/controller")
public class DockerSpringBoorController {

    @GetMapping("/index")
    public String index() {
        return "Docker Boot Example";
    }

}
