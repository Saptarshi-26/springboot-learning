package com.learning.springboot_learning.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Car {

     //Field injection  // Dependency injection , now Car is dependent on Dog
    @Autowired         // spring is providing a Dog object by the help of @Autowired annotation
             Dog dog;


    @GetMapping("/abc")
    String something (){
        return dog.bark();
    }
}
