package com.learning.springboot_learning;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class Dog {

    String bark(){
        return "woof";
    }
}
