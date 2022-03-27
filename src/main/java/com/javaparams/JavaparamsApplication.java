package com.javaparams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.javaparams")
public class JavaparamsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaparamsApplication.class, args);
    }

}
