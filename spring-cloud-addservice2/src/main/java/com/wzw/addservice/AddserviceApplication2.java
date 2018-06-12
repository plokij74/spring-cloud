package com.wzw.addservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AddserviceApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(AddserviceApplication2.class, args);
    }
}
