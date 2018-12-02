package com.company.application;

import static com.company.application.constants.Constant.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(COMPONENT_SCAN_PACKAGE)
public class BootStrap {

    public static void main(String args[]){
        SpringApplication.run(BootStrap.class);
    }
}
