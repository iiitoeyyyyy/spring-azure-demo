package com.demo.springapplication.controller;




import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class DemoApplicationAzureController {


    @GetMapping("/azure")
    public String runApplicationAzure(){
        log.info("Get Mapping");
        return "Springboot Application deployed Azure SuccessFully!!";
    }
}
