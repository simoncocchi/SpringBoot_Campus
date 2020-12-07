package com.microservice.microservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //Pour l'exercice du hello world
    @RequestMapping("/helloworld")
    public String HelloWorld(){
        return "Hello World";
    }


}
