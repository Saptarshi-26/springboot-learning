package com.learning.springboot_learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health_Check_Controller {

    @GetMapping("/health_Check")
    public String health_check(){
        return "ok";
    }
}
