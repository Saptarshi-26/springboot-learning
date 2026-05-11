package com.learning.springboot_learning.basics;

import org.springframework.stereotype.Component;

@Component
public class Dog {

    String bark(){
        return "woof";
    }
}
