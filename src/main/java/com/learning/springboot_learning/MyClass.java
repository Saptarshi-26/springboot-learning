package com.learning.springboot_learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyClass {
    @GetMapping("/hello")
    public String hello(){
        return  "hello";
    }
}
