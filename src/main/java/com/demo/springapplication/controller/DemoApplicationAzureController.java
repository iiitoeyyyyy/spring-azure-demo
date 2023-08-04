package com.demo.springapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApplicationAzureController {

    @GetMapping("/azure")
    public String runApplicationAzure(){
        return "Springboot Application deployed Azure SuccessFully!!";
    }
}
