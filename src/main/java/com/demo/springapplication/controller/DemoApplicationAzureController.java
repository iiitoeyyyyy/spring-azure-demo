package com.demo.springapplication.controller;




import com.demo.springapplication.model.User;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class DemoApplicationAzureController {


    @GetMapping("/azure")
    public String runApplicationAzure(){
        log.info("Get Mapping");
        return "Springboot Application deployed Azure SuccessFully!!";
    }

    @PostMapping("/greet/{name}")
    public ResponseEntity<String> SayHello(
            @PathVariable("name") String name,
            @RequestHeader(value="userId") String userId,
            @RequestBody User user
    ){
        String message = "Hello " + name+ " " + userId+ " " + user.getFirstName()+ " " + user.getLastName()+ " " +user.getAge();
        log.info("info2");
        log.info("Hello Message");
        log.info("info3");
        log.debug("Debug");
        log.warn("warning");
        log.error("error");
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
